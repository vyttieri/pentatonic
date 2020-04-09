package midi.events

trait Event {
  def getBytes: Array[Byte] = {
    Array[Byte](0)
  }
}
