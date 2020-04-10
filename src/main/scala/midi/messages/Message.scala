package midi.messages

import scala.collection.immutable.HashMap

class Message(val name: String, val statusByte: Byte = 0.toByte, val channel: Int = -1) {
  // TODO: Not all Messages have a channel val ????
  def getBytes: Array[Byte] = ???
}

// TODO: Figure out idiomatic way to do this
object Message {
  // As defined in the Detailed MIDI Specification v3
  val StatusBytes: HashMap[String, Byte] = HashMap(
    "NoteOff" -> 0x80.toByte,
    "NoteOn" -> 0x90.toByte,
    "Tempo" -> 0x51.toByte,
    "TimeSignature" -> 0x58.toByte
  )
}
