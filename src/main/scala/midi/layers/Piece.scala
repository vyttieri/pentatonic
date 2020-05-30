package midi.layers

import scala.collection.immutable.HashMap

import midi.Event
import midi.messages.ProgramChange

class Piece(val name: String) {
  lazy val instruments: new HashMap[String, List[Event]]
  def addInstrument(name: String, channel: Int = instruments.size {
    require (1 to 16 contains channel)

    instruments.put(name, new Event(new ProgramChange))
  }

  def write() {
  }
}
