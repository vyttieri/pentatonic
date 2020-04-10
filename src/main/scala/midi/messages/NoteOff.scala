package midi.messages

class NoteOff(
  channel: Int,
  val keyNumber: Int,
  val velocity: Int = 0
) extends ChannelMessage ("NoteOff", 0x80.toByte, channel) {
  override def getBytes: Array[Byte] = {
    Array[Byte]((0x80 | channel).toByte, keyNumber.toByte, velocity.toByte)
  }
}
