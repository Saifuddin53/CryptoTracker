package com.plcoding.cryptotracker.crypto.presentation.coin_screen

import androidx.compose.runtime.Immutable
import com.plcoding.cryptotracker.crypto.presentation.coin_screen.model.CoinUI

@Immutable
data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<CoinUI> = emptyList(),
    val selectedCoin: CoinUI? = null
)