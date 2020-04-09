package midi.messages

class EndOfTrack extends Message ("EndOfTrack", 0x2f.toByte) {
  override def getBytes: Array[Byte] = {
    Array[Byte](0xff.toByte, 0x2f.toByte, 0x00.toByte)
  }
}
