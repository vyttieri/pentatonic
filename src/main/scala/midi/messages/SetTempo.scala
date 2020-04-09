package midi.messages

import Message.StatusBytes

/**
  Represents a SetTempo message.

  FF 51 03 tttttt

  where tttttt (3 bytes) is microseconds per quarter note, OR
  24ths of a microsecond per MIDI clock.

  e.g.
  60 BPM = 1min / 60 quarter
  1 min = 60,000,000 microseconds
  10,000,000 microseconds / 1 quarter
  10,000,000 =


  e.g.
  FF 51 03

  60 quarter / minute

  1 quarter / 1000000 microseconds
**/
class SetTempo(microsPerQuarter: Int) extends Message ("Tempo", StatusBytes.get("Tempo").get) {
  // TODO: Validation to make sure microsPerQuarter fits in 3 bytes
  // TODO: better way to deal with 3 byte representation
  override def getBytes: Array[Byte] = {
    Array[Byte](0xff.toByte,
                statusByte,
                0x03.toByte,
                ((microsPerQuarter >> 16) & 0xff).toByte,
                ((microsPerQuarter >> 8) & 0xff).toByte,
                (microsPerQuarter & 0xff).toByte)
    }
}
