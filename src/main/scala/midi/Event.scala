package midi

import scala.annotation.tailrec
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

    Thanks to the fine people at https://github.com/MarkCWirt/MIDIUtil/
    so I didn't have to figure out this algorithm myself.
  **/
  private def getDeltaTimeBytes(): Array[Byte] = {
    @tailrec
    def loop(i: Int, deltaTimeBytes: List[Byte], highByte: Int = 0x80): Array[Byte] = {
      if (i == 0) deltaTimeBytes.reverse.toArray
      else loop(i >> 7, deltaTimeBytes :+ ((i & 0x7f | highByte) & 0xff).toByte)
    }

    if (deltaTime == 0) Array[Byte](0)
    else loop(deltaTime, List[Byte](), 0x00)
  }
}
