package com.example.cryptocurrencycleanarchitecture.domain.model

data class CryptoCoin(
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)
