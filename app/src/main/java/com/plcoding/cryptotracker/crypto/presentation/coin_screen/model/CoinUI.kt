package com.plcoding.cryptotracker.crypto.presentation.coin_screen.model

import androidx.annotation.DrawableRes
import com.plcoding.cryptotracker.crypto.data.Coin
import com.plcoding.cryptotracker.util.getDrawableIdForCoin
import java.text.NumberFormat
import java.util.Locale

data class CoinUI(
    val id: String,
    val name: String,
    val symbol: String,
    val rank: Int,
    val marketCapUsd: DisplayableNumber,
    val priceUsd: DisplayableNumber,
    val changePercent24Hr: DisplayableNumber,
    @DrawableRes val iconRes: Int
)

data class DisplayableNumber(
    val value: Double,
    val format: String
)

fun Coin.toCoinUI(): CoinUI {
    return CoinUI(
        id = id,
        name = name,
        symbol = symbol,
        rank = rank,
        marketCapUsd = marketCapUsd.toDisplayableNumber(),
        priceUsd = priceUsd.toDisplayableNumber(),
        changePercent24Hr = changePercent24Hr.toDisplayableNumber(),
        iconRes = getDrawableIdForCoin(symbol)
    )
}

fun Double.toDisplayableNumber(): DisplayableNumber {
    val formatter = NumberFormat.getNumberInstance(Locale.getDefault()).apply {
        minimumFractionDigits = 2
        maximumFractionDigits = 2
    }
    return DisplayableNumber(
        value = this,
        format = formatter.format(this)
    )
}