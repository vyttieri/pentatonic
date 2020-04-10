package midi.messages

class Message(val name: String, val statusByte: Byte) {
  def canEqual(a: Any) = a.isInstanceOf[Message]

  override def equals(that: Any): Boolean = {
    that match
    {
      case that: Message => that.canEqual(this) && this.hashCode == that.hashCode
    }
  }

  override def hashCode: Int = {
    val prime = 31
    var result = 1
    result = prime * result + statusByte.toInt
    result = prime * result + name.hashCode

    result
  }

  def getBytes: Array[Byte] = ???
}
