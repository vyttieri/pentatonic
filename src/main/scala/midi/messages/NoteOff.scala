package midi.messages

class NoteOff(
  override val channel: Int,
  val keyNumber: Int,
  val velocity: Int = 0
) extends ChannelMessage (0x80, channel) {
  override def getBytes: Array[Byte] = {
    Array[Byte]((status | channel).toByte, keyNumber.toByte, velocity.toByte)
  }
}
