package midi.events

class NoteOff(
val channel: Int,
val pitch: Int,
val tick: Int,
val volume: Int,
val annotation: String = ""
) extends Event {
  val eventName: String = "NoteOn"
  val midiStatus: Int = 0x80

  override def getBytes: Array[Byte] = ???
}
