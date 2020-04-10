package midi.chunks

import org.scalatest.FunSpec

import midi.Helpers.convertBytesToHex

class HeaderSpec extends FunSpec {
  describe("getBytes") {
    it("should output a byte string that matches the specification") {
     /** Example taken from the Complete MIDI 1.0 Detailed Specification, Standard MIDI Files
      Header chunk:
      4D 54 68 64   Mthd
      00 00 00 06   chunk length
      00 00         format 0
      00 01         one track
      00 60         96 per quarternote
      **/
      val ExpectedByteString = "4d54686400000006000000010060"

      val format: Short = 0
      val numTracks: Short = 1
      val division: Short = 96
      val header: Header = new Header(format, numTracks, division)
      assert(convertBytesToHex(header.getBytes) == ExpectedByteString)
    }
  }
}
