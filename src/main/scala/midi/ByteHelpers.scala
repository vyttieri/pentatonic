package midi

object ByteHelpers {
  // https://alvinalexander.com/source-code/scala-how-to-convert-array-bytes-to-hex-string/
  def convertBytesToHex(bytes: Seq[Byte]): String = {
    val sb = new StringBuilder
    for (b <- bytes) {
        sb.append(String.format("%02x", Byte.box(b)))
    }
    sb.toString
  }

  implicit class ShortWithGetBytes(val x: Short) {
    def getBytes: Array[Byte] = {
      Array[Byte](((x >> 8) & 0xff).toByte, (x & 0xff).toByte)
    }
  }

  implicit class IntWithGetBytes(val x: Int) {
    def getBytes: Array[Byte] = {
      Array[Byte](((x >> 24) & 0xff).toByte,
                  ((x >> 16) & 0xff).toByte,
                  ((x >> 8) & 0xff).toByte,
                  (x & 0xff).toByte)
    }
  }
}
