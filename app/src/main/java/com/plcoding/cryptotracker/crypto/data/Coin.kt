package com.plcoding.cryptotracker.crypto.data

data class Coin(
    val id: String,
    val name: String,
    val symbol: String,
    val rank: Int,
    val marketCapUsd: Double,
    val priceUsd: Double,
    val changePercent24Hr: Double
)
