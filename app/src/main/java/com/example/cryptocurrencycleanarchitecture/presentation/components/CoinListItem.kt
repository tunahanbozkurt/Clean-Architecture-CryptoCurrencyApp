package com.example.cryptocurrencycleanarchitecture.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cryptocurrencycleanarchitecture.domain.model.CryptoCoin

@Composable
fun CoinListItem(
    model: CryptoCoin
){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp), horizontalArrangement = Arrangement.SpaceBetween) {

        Text(text = "${model.rank}. ${model.name} ${model.symbol}",
        style = MaterialTheme.typography.body1,
        overflow = TextOverflow.Ellipsis)

        Text(
            text = if (model.is_active) "active" else "inactive",
            color = if (model.is_active) Color.Green else Color.Red,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.align(CenterVertically)
        )
    }

}

