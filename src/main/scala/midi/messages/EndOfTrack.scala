package midi.messages

class EndOfTrack extends Message (0x2f) {
  override def getBytes: Array[Byte] = {
    Array[Byte](0xff.toByte, status.toByte, 0x00.toByte)
  }
}
