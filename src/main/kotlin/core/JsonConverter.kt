package core

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.Base64

interface JsonConverter {
    fun convertAssertJsonToString(jsonFileName: String): Result<Fb2Book>

    class Converter : JsonConverter {

        private val json = Json {
            ignoreUnknownKeys = true
        }

        override fun convertAssertJsonToString(jsonFileName: String): Result<Fb2Book> {
            return try {
                val readString = File(jsonFileName)
                    .bufferedReader().use { buffered -> buffered.readText() }
                val decoded = json.decodeFromString<Fb2Book>(readString)
                println(decoded)
                Result.Success(decoded)
            } catch (e: IOException) {
                Result.Error(e.localizedMessage)
            }
        }
    }

    fun decodeImage(source: String?) {
        val decoder = Base64.getDecoder()
        val decoded = decoder.decode(source)
        saveImage(decoded)
    }

    fun saveImage(byteArray: ByteArray) {
        val file = File("assets/image.jpeg")
        try {
            val outputStream = FileOutputStream(file)
            outputStream.write(byteArray)
        } catch (e: Exception) {
            println(e.localizedMessage)
        }
    }
}

