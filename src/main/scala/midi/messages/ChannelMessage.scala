package midi.messages

class ChannelMessage(name: String, statusByte: Byte, val channel: Int) extends Message (name, statusByte) {
}
