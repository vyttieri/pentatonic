package midi.chunks

import midi.Event
import midi.messages.EndOfTrack

import scala.collection.immutable.Queue
import scala.math.BigInt

case class Track(val events: Queue[Event] = Queue[Event]()) extends Chunk {
  /**
    Represents a MIDI Track Chunk.
    A Track Chunk consists of:

    "MTrk" - 4 bytes - Indicates the beginning of a track
    <length> - 4 bytes - The number of bytes in the track chunk,
    following this number
    <track_event>* - zero or more sequenced track events
  **/
  def addEvent(event: Event): Track = {
    if (
      !events.isEmpty &&
      events.last.message.getClass == event.message.getClass &&
      events.last.message.channel == event.message.channel
    ) {
      this.copy(events :+ event.copy(runningStatus = true))
    } else {
      this.copy(events :+ event)
    }
  }

  def getBytes: Array[Byte] = {
    val indicator = "MTrk".getBytes

    val eventBytes: Array[Byte] = events.map(x => x.getBytes).reduce((x, y) => x ++ y)
    // TODO: should endOfTrack be manually added?
    val endOfTrackEvent = new Event(new EndOfTrack, 0)

    indicator ++ getChunkLengthBytes ++ eventBytes ++ endOfTrackEvent.getBytes
  }

  private def getChunkLengthBytes: Array[Byte] = {
    val length = events.map(x => x.getBytes.size).reduce((x, y) => x + y)

    Array[Byte](((length >> 24) & 0xff).toByte,
                ((length >> 16) & 0xff).toByte,
                ((length >> 8) & 0xff).toByte,
                (length & 0xff).toByte)
  }
}
