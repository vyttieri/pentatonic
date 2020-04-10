package midi.messages

class Message(val name: String, val statusByte: Byte) {
  def getBytes: Array[Byte] = ???
}
