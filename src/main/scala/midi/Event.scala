package midi

import midi.messages.Message

class Event(val message: Message, val deltaTime: Int) {
  // TODO: DeltaTime is fucking up
  def getBytes: Array[Byte] = {
    Array[Byte](deltaTime.toByte) ++ message.getBytes
  }
}
