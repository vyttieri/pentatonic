package midi

import java.io.{BufferedOutputStream, FileOutputStream}

class MIDIFile {
  val header = new HeaderChunk()
  val tracks = List[TrackChunk]()


  def addNote: Unit = {
    // if (header.format)
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