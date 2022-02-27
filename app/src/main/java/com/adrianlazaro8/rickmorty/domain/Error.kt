package com.adrianlazaro8.rickmorty.domain


sealed class Error {
    object Connectivity : Error()
    class Server(val code: Int) : Error()
    class Unknown(message: String) : Error()
}

fun Exception.toError(message: String = ""): Error {
    when (this) {
        else -> Error.Unknown(message)
    }
    return Error.Unknown(message)
}
