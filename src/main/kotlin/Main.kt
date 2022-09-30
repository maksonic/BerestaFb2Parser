import core.Fb2ToStringConverter
import core.JsonConverter
import core.JsonCreator
import java.io.File
import java.io.FileOutputStream
import java.util.*

fun main() {
      val jsonFileName = "assets/raw.json"
    val fb2ToStringConverter = Fb2ToStringConverter.Converter(Fb2Store.fb2FileName)
    val jsonCreator = JsonCreator.Creator(fb2ToStringConverter)
    jsonCreator.createJsonFileFromFb2String(jsonFileName)

  //  val jsonConverter = JsonConverter.Converter()
  //  jsonConverter.convertAssertJsonToString(jsonFileName)
x()
}

    fun x() {

        val s = "\"binary\""
        /* val w = "binary": [
             {
                 "content-type": "image/png",
                 "id": "i_001.png", "
                 }
         ]*/

        println(s)
    }


fun encoder() {
    val encoder = Base64.getEncoder()
    val decoder = Base64.getDecoder()
   /* val file = File("assets/sw.jpg")
    val bytes = File("assets/bytes.txt")
    val result = encoder.encodeToString(file.readBytes())
    bytes.createNewFile()
    bytes.writeText(result)
    println(result)*/
    val readString = File("assets/bytes.txt").bufferedReader().use { buffered -> buffered.readText() }
    val w = decoder.decode(readString)
    saveImage(w)

}

fun saveImage(byteArray: ByteArray) {
    val file = File("assets/some.png")
    try {
        val outputStream = FileOutputStream(file)
        outputStream.write(byteArray)
    } catch (e: Exception) {
        println(e.localizedMessage)
    }
}