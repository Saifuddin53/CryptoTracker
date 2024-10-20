package com.plcoding.cryptotracker.core.networking

import com.plcoding.cryptotracker.core.util.NetworkError
import com.plcoding.cryptotracker.core.util.Result
import io.ktor.client.call.NoTransformationFoundException
import io.ktor.client.statement.HttpResponse
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.coroutines.ensureActive
import kotlinx.serialization.SerializationException
import kotlin.coroutines.coroutineContext

suspend inline fun <reified T> safeCall(
    execute: () -> HttpResponse
): Result<T, NetworkError> {
    val response = try {
        execute()
    } catch (e: UnresolvedAddressException) {
        return Result.Error(NetworkError.NO_INTERNET)
    } catch (e: SerializationException) {
        return Result.Error(NetworkError.SERIALIZATION)
    } catch (e: Exception) {
        coroutineContext.ensureActive()
        return Result.Error(NetworkError.UNKNOWN)
    }

    return responseToResult(response)
}