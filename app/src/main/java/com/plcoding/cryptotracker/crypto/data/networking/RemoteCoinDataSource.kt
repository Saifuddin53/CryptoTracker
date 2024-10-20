package com.plcoding.cryptotracker.crypto.data.networking

import com.plcoding.cryptotracker.core.networking.constructUrl
import com.plcoding.cryptotracker.core.networking.safeCall
import com.plcoding.cryptotracker.core.util.NetworkError
import com.plcoding.cryptotracker.core.util.Result
import com.plcoding.cryptotracker.core.util.map
import com.plcoding.cryptotracker.crypto.data.CoinDataResponse
import com.plcoding.cryptotracker.crypto.data.mappers.toCoin
import com.plcoding.cryptotracker.crypto.domain.Coin
import com.plcoding.cryptotracker.crypto.domain.CoinDataSource
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class RemoteCoinDataSource(
    private val httpClient: HttpClient
): CoinDataSource {

    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinDataResponse> {
            httpClient.get(
                urlString = constructUrl("/assets")
            )
        }.map { response ->
            response.data.map { it.toCoin() }
        }
    }

}