package midi


import java.io.{BufferedOutputStream, FileOutputStream}

import scala.collection.immutable.Queue

import midi.chunks.{Header, Track}

case class File(
  val format: Short,
  val numTracks: Short,
  val division: Short,
  val tracks: Queue[Track] = Queue[Track]()
) {
  val header =
    new Header(
      format = format,
      numTracks = numTracks,
      division = division)

  def addTrack(track: Track): File = {
    if (header.format == 0) { assert(tracks.size == 0) }

    this.copy(tracks = tracks :+ track)
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
