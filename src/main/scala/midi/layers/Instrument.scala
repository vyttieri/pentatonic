package midi.layers

object layers {
  def addInstrument(channel: Int) {
    require (1 to 16 contains channel)
  }
}
