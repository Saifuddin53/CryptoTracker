package com.plcoding.cryptotracker.crypto.presentation.coin_list.components

import com.plcoding.cryptotracker.crypto.presentation.coin_list.model.CoinUI

sealed interface CoinListAction {
    data class OnCoinClick(val coinUI: CoinUI): CoinListAction
}