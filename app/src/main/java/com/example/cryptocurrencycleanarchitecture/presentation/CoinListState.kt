package com.example.cryptocurrencycleanarchitecture.presentation

import com.example.cryptocurrencycleanarchitecture.domain.model.CryptoCoin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<CryptoCoin> = emptyList(),
    val error: String = ""
)



