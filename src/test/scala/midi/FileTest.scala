package midi

import org.scalatest.FunSpec

import midi.{Event, File}
import midi.chunks.Track
import midi.messages._

/** Example taken from the Complete MIDI Specification 1.0 Detailed Specification
  Header chunk:
  4D 54 68 64   Mthd
  00 00 00 06   chunk length
  00 00         format 0
  00 01         one track
  00 60         96 per quarternote
  Track chunk:
  4D 54 72 6B   Mtrk
  00 00 00 3B   chunk length (59)

  Events:
  Delta-Time    Event                   Comments
  00            FF 58 04 04 02 18 08    time signature
  00            FF 51 03 07 A1 20       tempo
  00            C0 05
  00            C1 2E
  00            C2 46
  00            92 30 60
  00            3C 60                   running status
  60            91 43 40
  60            90 4C 20
 81 40          82 30 40                two-byte delta-time
  00            3C 40                   running status
  00            81 43 40
  00            80 4C 40
  00            FF 2F 00                end of track
**/

class FileSpec extends FunSpec {

  val tsEvent = new Event(new TimeSignature(4, 2, 24, 8), 0)
  val setTempoEvent = new Event(new SetTempo(500000), 0)
  val programChange1 = new Event(new ProgramChange(1, 5), 0)
  val programChange2 = new Event(new ProgramChange(2, 46), 0)
  val programChange3 = new Event(new ProgramChange(3, 70), 0)
  val noteOnEvent1 = new Event(new NoteOn(3,48, 96), 0)
  val noteOnEvent2 = new Event(new NoteOn(3,60, 96), 0)
  val noteOnEvent3 = new Event(new NoteOn(2,67, 64), 96)
  val noteOnEvent4 = new Event(new NoteOn(1,76, 32), 96)
  val noteOffEvent1 = new Event(new NoteOff(3,48, 96), 192)
  val noteOffEvent2 = new Event(new NoteOff(3,60, 96), 192)
  val noteOffEvent3 = new Event(new NoteOff(2,67, 64), 192)
  val noteOffEvent4 = new Event(new NoteOff(1,76, 32), 192)
  val myTrack = new Track().addEvent(tsEvent)
                   .addEvent(setTempoEvent)
                   .addEvent(programChange1)
                   .addEvent(programChange2)
                   .addEvent(programChange3)
                   .addEvent(noteOnEvent1)
                   .addEvent(noteOnEvent2)
                   .addEvent(noteOnEvent3)
                   .addEvent(noteOnEvent4)
                   .addEvent(noteOffEvent1)
                   .addEvent(noteOffEvent2)
                   .addEvent(noteOffEvent3)
                   .addEvent(noteOffEvent4)
  val myMidi = new File(0, 1, 96).addTrack(myTrack)
  // myMidi.getBytes
  myMidi.write("test.mid")

  describe("format 0 File") {
  }
}
