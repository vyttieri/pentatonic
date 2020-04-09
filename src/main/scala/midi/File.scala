package midi


import java.io.{BufferedOutputStream, FileOutputStream}

import scala.collection.immutable.Queue

import midi.chunks.{Header, Track}

class File(
  val format: Short,
  val numTracks: Short,
  val division: Short
) {
  val header =
    new Header(
      format = format,
      numTracks = numTracks,
      division = division)
  var tracks = Queue[Track]()

  def addTrack(track: Track): Unit = {
    if (header.format == 0) { assert(tracks.size == 0) }

    tracks = tracks :+ track
  }

  def getBytes: Array[Byte] = {
    header.getBytes ++ tracks.map(x => x.getBytes).reduce((x, y) => x ++ y)
  }

  def write(filename: String): Unit = {
    val stream = new BufferedOutputStream(new FileOutputStream(filename))

    stream.write(getBytes)

    stream.close
  }
}
