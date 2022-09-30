package core

import java.io.File

interface Fb2ToStringConverter {
    fun convertFb2ToString(): Result<String>

    class Converter(private val fb2FileName: String) : Fb2ToStringConverter {
        override fun convertFb2ToString(): Result<String> =
            try {
                val stringResult = File(fb2FileName).readText()
                Result.Success(stringResult)
            } catch (e: Exception) {
                println(e.localizedMessage)
                Result.Error(e.localizedMessage)
            }
    }
}