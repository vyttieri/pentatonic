package midi.messages

case class ProgramChange(
  override val channel: Int,
  val data: Int
) extends ChannelMessage (0xc0, channel) {
  require(0 to 127 contains data.toByte)

  override def getBytes: Array[Byte] = {
    Array[Byte]((status | channel).toByte, data.toByte)
  }
}
