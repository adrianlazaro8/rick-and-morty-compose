package com.adrianlazaro8.rickmorty.domain

sealed class Error {
    class Unknown(message: String) : Error()
}

fun Exception.toError(message: String = ""): Error {
    return Error.Unknown(message)
}
