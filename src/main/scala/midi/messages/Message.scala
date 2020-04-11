package midi.messages

abstract class Message(val status: Int) {
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
    result = prime * result + status.toByte
    result = prime * result + this.getClass.toString.hashCode

    result
  }

  def getBytes: Array[Byte]
}
