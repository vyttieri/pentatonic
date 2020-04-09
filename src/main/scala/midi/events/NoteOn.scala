package midi.events

class NoteOn(
val channel: Int,
val pitch: Int,
val tick: Int,
val duration: Int,
val volume: Int,
val annotation: String = ""
) extends Event {
  val eventName: String = "NoteOn"
  val midiStatus = 0x90



  override def getBytes: Array[Byte] = ???
}
