package midi.messages

class ProgramChange(
  channel: Int,
  val dataByte: Int
) extends Message ("ProgramChange", channel = channel) {
  override def getBytes: Array[Byte] = {
    Array[Byte]((0xc0 | channel).toByte, dataByte.toByte)
  }
}

