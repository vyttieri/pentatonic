package midi.messages

import java.nio.ByteBuffer

import midi.Helpers.IntWithGetBytes

/**
  Represents a Time Signature message.

  The time signature is expresesd as four numbers:
  FF 58 04 nn dd cc bb
  nn represents the numerator of the time signature
  dd represents the denominator of the time signature
  cc represents the number of MIDI clocks in a metronome tick
  bb expresses the number of notated 32nd-notes in a MIDI quarter-note (24 MIDI clocks)
    - http://www.music.mcgill.ca/~ich/classes/mumt306/StandardMIDIfileformat.html

  e.g.
  FF 58 04 04 02 18 08 - 4/4, 18 MIDI clocks / tick, 8 notated 32nd notes in a MIDI quarter-note.
**/
class TimeSignature(
  val numerator: Int,
  val denominator: Int,
  val clocksPerTick: Int,
  val notesPerQuarter: Int
) extends Message ("TimeSignature", 0x58) {
  // TODO: validation
  override def getBytes: Array[Byte] = {
    Array[Byte](0xff.toByte,
                statusByte,
                0x04.toByte,
                numerator.toByte,
                denominator.toByte,
                clocksPerTick.toByte,
                notesPerQuarter.toByte)
  }
}


/****

track = new track
track.addNote


****////


