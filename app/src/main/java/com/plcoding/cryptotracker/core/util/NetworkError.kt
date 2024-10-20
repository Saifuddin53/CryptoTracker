package com.plcoding.cryptotracker.core.util

enum class NetworkError: Error {
    SERIALIZATION,
    TOO_MANY_REQUESTS,
    NO_INTERNET,
    REQUEST_TIMEOUT,
    SERVER_ERROR,
    UNKNOWN
}