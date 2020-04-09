package midi

import events.Event

import scala.math.BigInt

class TrackChunk {
  /**
    Represents a MIDI Track Chunk.
    A Track Chunk consists of:

    "Mtrk" - 4 bytes - Indicates the beginning of a track
    <length> - 4 bytes - The number of bytes in the track chunk,
    following this number
    <track_event>* - zero or more sequenced track events
  **/
  var events = List[Event]()



  def addEvent: Unit = {

  }

  def getBytes: Array[Byte] = {
    val indicator = "Mtrk".getBytes

    val length = BigInt(events.length * 4).toByteArray

    val eventBytes: Array[Byte] = events.map(x => x.getBytes).reduce((x, y) => x ++ y)

    indicator ++ length ++ eventBytes
  }
}
