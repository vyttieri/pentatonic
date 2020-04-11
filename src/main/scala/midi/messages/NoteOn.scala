package midi.messages

case class NoteOn(
  override val channel: Int,
  val keyNumber: Int,
  val velocity: Int,
) extends ChannelMessage (0x90, channel) {
  require(0 to 127 contains velocity)
  override def getBytes: Array[Byte] = {
    Array[Byte]((status | channel).toByte, keyNumber.toByte, velocity.toByte)
  }
}
