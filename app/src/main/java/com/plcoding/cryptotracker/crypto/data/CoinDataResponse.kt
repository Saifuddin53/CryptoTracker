package com.plcoding.cryptotracker.crypto.data

import kotlinx.serialization.Serializable

@Serializable
data class CoinDataResponse(
    val data: List<CoinDto>
)
