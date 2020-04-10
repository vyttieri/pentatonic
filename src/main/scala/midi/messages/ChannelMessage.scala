package midi.messages

class ChannelMessage(
  name: String,
  statusByte: Byte,
  val channel: Int
) extends Message (name, statusByte) {
  require(0 to 15 contains channel)

  override def canEqual(a: Any) = a.isInstanceOf[ChannelMessage]

  override def hashCode: Int = {
    val prime = 31
    var result = 1
    result = prime * result + statusByte.toInt + channel
    result = prime * result + name.hashCode

    result
  }
}
