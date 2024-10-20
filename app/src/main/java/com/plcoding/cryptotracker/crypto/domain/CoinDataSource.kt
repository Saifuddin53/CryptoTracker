package com.plcoding.cryptotracker.crypto.domain

import com.plcoding.cryptotracker.core.util.NetworkError
import com.plcoding.cryptotracker.core.util.Result

interface CoinDataSource {

    suspend fun getCoins(): Result<List<Coin>, NetworkError>

}