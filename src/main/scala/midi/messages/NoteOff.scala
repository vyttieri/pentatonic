package midi.messages

class NoteOff(
  val keyNumber: Int,
  val velocity: Int = 0
) extends Message ("NoteOff", 0x80.toByte) {
  override def getBytes: Array[Byte] = {
    Array[Byte](statusByte, keyNumber.toByte, velocity.toByte)
  }
}
