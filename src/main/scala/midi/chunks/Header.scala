package midi.chunks

import midi.Helpers.ShortWithGetBytes

class Header(
  val format: Short,
  val numTracks: Short,
  val division: Short
) extends Chunk {
  private val VALID_FORMAT_VALUES = Set(0, 1, 2)

  require(VALID_FORMAT_VALUES.contains(format))

/**
  Adapted from http://www.ccarh.org/courses/253/handout/smf/ and
  http://www.music.mcgill.ca/~ich/classes/mumt306/StandardMIDIfileformat.html#BM2_1

  Represents a MIDI Header Chunk. The header consists of 5 parts:

  "MThd" - 4 bytes - indicates that a MIDI file
  headerLength - 4 bytes - length of the header (always 6 bytes)
  format - 2 bytes -
    0 = single track file format
    1 = multiple track file format
    2 = multiple song file format
  ntrks - 2 bytes - number of track chunks that follow the header chunk
  divison - 2 bytes - unit of time for delta timing.
  If positive, it represents unit per beat (e.g. 60 would mean 60 ticks per beat).
  If negative, delta times are in SMPTE compatible units.
**/

  def getBytes: Array[Byte] = {
    // TODO: efficiency
    val headerLength = Array[Byte](0x00, 0x00, 0x00, 0x06)  /*>  Array(0, 0, 0, 6)  */

    "MThd".getBytes ++ headerLength ++ format.getBytes ++ numTracks.getBytes ++ division.getBytes
  }
}
