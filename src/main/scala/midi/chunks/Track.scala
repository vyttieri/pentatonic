package midi.chunks

import midi.Event
import midi.messages.EndOfTrack

import scala.collection.immutable.Queue
import scala.math.BigInt

class Track extends Chunk {
  /**
    Represents a MIDI Track Chunk.
    A Track Chunk consists of:

    "Mtrk" - 4 bytes - Indicates the beginning of a track
    <length> - 4 bytes - The number of bytes in the track chunk,
    following this number
    <track_event>* - zero or more sequenced track events
  **/
  var events = Queue[Event]()

  def addEvent(event: Event): Unit = {
    events = events :+ event
  }

  def getBytes: Array[Byte] = {
    val indicator = "MTrk".getBytes

    val length: Byte = events.map(x => x.getBytes.size).reduce((x, y) => x + y).toByte
    println("wtf")
    println(length)

    val eventBytes: Array[Byte] = events.map(x => x.getBytes).reduce((x, y) => x ++ y)

    val endOfTrackEvent = new Event(new EndOfTrack, 0)

    indicator ++ Array[Byte](length) ++ eventBytes ++ endOfTrackEvent.getBytes
  }
}
