package midi.messages

class NoteOn(
  channel: Int,
  val keyNumber: Int,
  val velocity: Int,
) extends ChannelMessage ("NoteOn", 0x90.toByte, channel) {
  // TODO: Validation
  override def getBytes: Array[Byte] = {
    Array[Byte]((0x90 | channel).toByte, keyNumber.toByte, velocity.toByte)
  }
}
