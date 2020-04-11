package midi.messages

import midi.ByteHelpers.ShortWithGetBytes

class SequenceNumber(val sequenceNumber: Short) extends Message (0x00) {
  override def getBytes: Array[Byte] = {
    Array[Byte](0xff.toByte,
                status.toByte,
                0x02.toByte) ++
                sequenceNumber.getBytes
  }
}
