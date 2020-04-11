package midi.messages

/** Key Signature
FF 59 02 sf mi
sf = -7: 7 flats
sf = -1: 1 flat
sf = 0: key of C
sf = 7: 7 sharps
mi = 0: major key
mi = 1: minor key
- Complete Midi Spec
**/
class KeySignature(sf: Int, mi: Int) extends Message ("KeySignature", 0x59.toByte){
  require(-7 to 7 contains sf)
  require(0 to 1 contains mi)

  override def getBytes: Array[Byte] = {
    Array[Byte](0xff.toByte, statusByte, 0x02.toByte, sf.toByte, mi.toByte)
  }
}
