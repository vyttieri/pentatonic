package midi.events

import midi.events.NoteOn
import org.scalatest.FunSpec

class NoteOnSpec extends FunSpec {
  describe("Note on") {
    describe("when created") {
      val noteOn = new NoteOn(
        channel = 0,
        pitch = 0,
        tick = 0,
        duration = 0,
        volume = 0,
      )
      it("should have channel") {
        assert(noteOn.channel == 0)
      }

      it("should have pitch") {
        assert(noteOn.pitch == 0)
      }

      it("should have tick") {
        assert(noteOn.tick == 0)
      }

      it("should have duration") {
        assert(noteOn.duration == 0)
      }

      it("should have volume") {
        assert(noteOn.volume == 0)
      }

      it("should have default annotation of \"\"") {
        assert(noteOn.annotation == "")
      }

      it("should have optionally assignable annotation") {
        val noteOn = new NoteOn(
          channel = 0,
          pitch = 0,
          tick = 0,
          duration = 0,
          volume = 0,
          annotation = "my annotation"
        )

        assert(noteOn.annotation == "my annotation")
      }

      it("should have eventName NoteOn") {
        assert(noteOn.eventName == "NoteOn")
      }
    }
  }
}
