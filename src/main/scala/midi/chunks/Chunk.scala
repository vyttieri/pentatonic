package midi.chunks

trait Chunk {
  def getBytes: Array[Byte]
}
