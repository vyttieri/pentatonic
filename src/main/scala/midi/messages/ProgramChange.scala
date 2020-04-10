package midi.messages

class ProgramChange(
  channel: Int,
  val dataByte: Int
) extends ChannelMessage("ProgramChange", 0xc0.toByte, channel) {
  require(0 to 127 contains dataByte)

  override def getBytes: Array[Byte] = {
    Array[Byte]((0xc0 | channel).toByte, dataByte.toByte)
  }
}
