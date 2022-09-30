package core

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Fb2Book(
    @SerialName("FictionBook")
    val fictionBook: FictionBook
) {
    //fun getImageBase64(): String? = fictionBook.binaryModel.content
}

@Serializable
data class FictionBook(
    @SerialName("xmlns")
    val xmlns: String = "",
    @SerialName("binary")
    val binary: Array<Binary>?
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as FictionBook

        if (xmlns != other.xmlns) return false
        if (!binary.contentEquals(other.binary)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = xmlns.hashCode()
        result = 31 * result + binary.contentHashCode()
        return result
    }
}


@Serializable
data class Binary(
    @SerialName("content-type")
    val contentType: String = "",
    @SerialName("id")
    val id: String = "",
    @SerialName("content")
    val content: String? = "",
   /* @SerialName("description")
    val description: Description*/
)


@Serializable
data class Content(
    @SerialName("content-type")
    val contentType: String = "",
    @SerialName("id")
    val id: String = "",
    @SerialName("content")
    val content: String? = "",
)


/*
@Serializable
data class BinaryModel(
    @SerialName("content-type")
    val contentType: String = "",
    @SerialName("id")
    val id: String = "",
    @SerialName("content")
    val content: String? = "",
   *//* @SerialName("description")
    val description: Description*//*
)*/


@Serializable
data class Description(
    val x: String
)

/*

@Serializable
data class XmlnsModel(
    @SerialName("xmlns")
    val xmlns: String = "",
)
@Serializable
data class BinaryModel(
    @SerialName("content-type")
    val contentType: String = "",
    @SerialName("id")
    val id: String = "",
    @SerialName("content")
    val content: String? = ""
)*/
