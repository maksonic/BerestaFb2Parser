package core

sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: String) : Result<Nothing>()
}

inline fun <reified T> Result<T>.onSuccess(callback: (value: T) -> Unit) {
    if (this is Result.Success) callback(data)
}

inline fun <reified T> Result<T>.onError(callback: (error: String?) -> Unit) {
    if (this is Result.Error) callback(exception)
}


