package com.ravimhzn.mynotes


sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(message: String, data: T) : Resource<T>(data, message)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
}
