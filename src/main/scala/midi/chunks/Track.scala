package midi.chunks

import midi.Event
import midi.ByteHelpers.IntWithGetBytes
import midi.messages.ChannelMessage

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
    // TODO: Yikes
    if (
      !events.isEmpty &&
      events.last.message.statusByte == event.message.statusByte &&
      events.last.message.isInstanceOf[ChannelMessage] &&
      event.message.isInstanceOf[ChannelMessage] &&
      events.last.message.asInstanceOf[ChannelMessage].channel ==
        event.message.asInstanceOf[ChannelMessage].channel
    ) {
      this.copy(events :+ event.copy(runningStatus = true))
    } else {
      this.copy(events :+ event)
    }
  }

  def getBytes: Array[Byte] = {
    "MTrk".getBytes ++
    getChunkLengthBytes ++
    getEventBytes
  }

  private def getChunkLengthBytes: Array[Byte] = {
    events.map(x => x.bytes.size).reduce((x, y) => x + y).getBytes
  }

  private def getEventBytes: Array[Byte] = {
    events.map(x => x.bytes).reduce((x, y) => x ++ y)
  }
}
