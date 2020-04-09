package midi.messages

import org.scalatest.FunSpec

class NoteOffSpec extends FunSpec {
  describe("getBytes") {
    it("should convert inputs to correct Array[Byte]") {
      val noteOff = new NoteOff(48, 96)
    }
  }
}
