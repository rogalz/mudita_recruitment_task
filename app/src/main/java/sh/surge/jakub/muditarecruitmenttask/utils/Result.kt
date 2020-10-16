package sh.surge.jakub.muditarecruitmenttask.utils

sealed class Result<out T : Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    object EmptyResult : Result<Nothing>()
    data class NetworkException(val error: String) : Result<Nothing>()
    data class HttpError(val errorCode: Int, val error: String) : Result<Nothing>()
}