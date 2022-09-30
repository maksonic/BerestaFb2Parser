package core

import org.json.XML
import java.io.File

interface JsonCreator {
    fun createJsonFileFromFb2String(nameOfSavedFile: String)
    fun writeDataToJsonFile(file: File, data: String)

    class Creator(private val fb2Converter: Fb2ToStringConverter) : JsonCreator {
        override fun createJsonFileFromFb2String(nameOfSavedFile: String) {
            val conversion = fb2Converter.convertFb2ToString()

            conversion.onSuccess { data ->
                val jsonObj = XML.toJSONObject(data)
                val jsonPrettyPrintString = jsonObj.toString(2)
                val file = File(nameOfSavedFile)
                file.createNewFile()
                writeDataToJsonFile(file, jsonPrettyPrintString)
            }
            conversion.onError { message -> println(message) }
        }

        override fun writeDataToJsonFile(file: File, data: String): Unit = file.writeText(data)
    }
}