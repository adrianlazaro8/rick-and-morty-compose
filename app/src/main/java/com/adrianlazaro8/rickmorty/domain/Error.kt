package com.adrianlazaro8.rickmorty.domain

import retrofit2.HttpException
import java.io.IOException

sealed class Error {
    object Connectivity : Error()
    class Server(val code: Int) : Error()
    class Unknown(message: String) : Error()
}

fun Exception.toError(message: String = ""): Error {
    return when (this) {
        is IOException -> Error.Connectivity
        is HttpException -> Error.Server(code())
        else -> Error.Unknown(message)
    }
}
