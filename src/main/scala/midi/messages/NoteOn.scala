package midi.messages

class NoteOn(
  // val channel: Int,
  val keyNumber: Int,
  val velocity: Int,
  // val annotation: String = ""
) extends Message ("NoteOn", 0x90.toByte) {
  // TODO: Validation
  override def getBytes: Array[Byte] = {
    Array[Byte](statusByte, keyNumber.toByte, velocity.toByte)
  }
}
