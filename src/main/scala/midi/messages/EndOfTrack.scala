package midi.messages

class EndOfTrack extends Message ("EndOfTrack", 0x2f.toByte) {
  override def getBytes: Array[Byte] = {
    Array[Byte](0xff.toByte, statusByte, 0x00.toByte)
  }
}
