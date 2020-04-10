package midi

import scala.collection.mutable.ListBuffer

import midi.messages.Message

case class Event(
  val message: Message,
  val deltaTime: Int = 0x00,
  val runningStatus: Boolean = false
) {
  lazy val bytes: Array[Byte] = getBytes

  def getBytes: Array[Byte] = {
    if (runningStatus)
      getDeltaTimeBytes ++ message.getBytes.tail
    else
      getDeltaTimeBytes ++ message.getBytes

  }

  /**
    deltaTime lengths are stored in variable-length bytes.

  **/
  private def getDeltaTimeBytes(): Array[Byte] = {
    if (deltaTime == 0) { return Array[Byte](0) }

    var vlbytes = new ListBuffer[Byte]()
    var hibit = 0x00
    var i = deltaTime
    while (i > 0) {
      vlbytes += (((i & 0x7f | hibit) & 0xff)).toByte
      i = i >> 7
      hibit = 0x80
    }

    vlbytes.reverse.toArray
  }
}
