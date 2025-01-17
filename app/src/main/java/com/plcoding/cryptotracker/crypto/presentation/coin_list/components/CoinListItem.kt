package com.plcoding.cryptotracker.crypto.presentation.coin_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.cryptotracker.crypto.domain.Coin
import com.plcoding.cryptotracker.crypto.presentation.coin_list.model.CoinUI
import com.plcoding.cryptotracker.crypto.presentation.coin_list.model.toCoinUI
import com.plcoding.cryptotracker.ui.theme.CryptoTrackerTheme

@Composable
fun CoinListItem(
    coinUI: CoinUI,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val contentColor = if(isSystemInDarkTheme()) {
        Color.White
    } else {
        Color.Black
    }

    Row(
        modifier = modifier
            .padding(8.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = coinUI.iconRes),
            contentDescription = coinUI.name,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(80.dp)
        )
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = coinUI.symbol,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = contentColor
            )
            Text(
                text = coinUI.name,
                fontWeight = FontWeight.Light,
                fontSize = 12.sp,
                color = contentColor
            )
        }
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "$ ${coinUI.marketCapUsd.format}",
                fontWeight = FontWeight.Bold,
                fontSize = 11.sp,
                color = contentColor
            )
            Spacer(modifier = Modifier.height(8.dp))
            PriceChange(change = coinUI.changePercent24Hr)
        }
    }
}

@Preview
@PreviewLightDark
@Composable
fun CoinListItemPreview(modifier: Modifier = Modifier) {
    CryptoTrackerTheme {
        CoinListItem(
            coinUI = coinUIPreviewItem,
            onClick = { /*TODO*/ },
            modifier = Modifier.background(
                MaterialTheme.colorScheme.primaryContainer
            )
        )
    }
}

internal val coinUIPreviewItem = Coin(
    id = "id",
    name = "Bitcoin",
    symbol = "BTC",
    rank = 1,
    marketCapUsd = 1324324.23,
    priceUsd = 1324324.23,
    changePercent24Hr = -42.23
).toCoinUI()

