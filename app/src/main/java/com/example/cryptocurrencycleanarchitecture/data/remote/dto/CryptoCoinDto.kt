package com.example.cryptocurrencycleanarchitecture.data.remote.dto

import com.example.cryptocurrencycleanarchitecture.data.local.CryptoEntity
import com.example.cryptocurrencycleanarchitecture.domain.model.CryptoCoin


data class CryptoCoinDto(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
){
    fun toCryptoEntity(): CryptoEntity{
        return CryptoEntity(
            is_active = is_active,
            is_new = is_new,
            name = name,
            rank = rank,
            symbol = symbol,
            type = type
        )
    }

}