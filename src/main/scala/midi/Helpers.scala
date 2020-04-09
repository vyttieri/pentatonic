package midi

object Helpers {
  implicit class ShortWithGetBytes(val x: Short) {
    def getBytes: Array[Byte] = {
      Array[Byte]((x & 0xff).toByte, ((x >> 8) & 0xff).toByte)
    }
  }
}
