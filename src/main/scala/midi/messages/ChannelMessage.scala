package midi.messages

abstract class ChannelMessage(
  override val status: Int,
  val channel: Int)
extends Message (status) {
  require(0 to 15 contains channel)

  override def canEqual(a: Any) = a.isInstanceOf[ChannelMessage]

  override def hashCode: Int = {
    val prime = 31
    var result = 1
    result = prime * result + status + channel
    result = prime * result + this.getClass.toString.hashCode

    result
  }
}
