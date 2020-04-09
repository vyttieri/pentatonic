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
  val myMidi = new File(0, 1, 96)
  val myTrack = new Track
  val tsEvent = new Event(new TimeSignature(4, 2, 24, 8), 0)
  val setTempoEvent = new Event(new SetTempo(500000), 0)
  val noteOnEvent = new Event(new NoteOn(48, 96), 0)
  val noteOffEvent = new Event(new NoteOff(48, 96), 192)
  myTrack.addEvent(tsEvent)
  myTrack.addEvent(setTempoEvent)
  myTrack.addEvent(noteOnEvent)
  myTrack.addEvent(noteOffEvent)
  myMidi.addTrack(myTrack)
  myMidi.getBytes
  myMidi.write("test.mid")

  describe("format 0 File") {
  }
}
