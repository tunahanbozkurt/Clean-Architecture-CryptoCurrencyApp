package com.example.cryptocurrencycleanarchitecture.data.local


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cryptocurrencycleanarchitecture.domain.model.CryptoCoin

@Entity
data class CryptoEntity(
    @PrimaryKey val uid: Int? = null,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
){
    fun toCryptoCoin(): CryptoCoin{
        return CryptoCoin(
            is_active = is_active,
            is_new = is_new,
            name = name,
            rank = rank,
            symbol = symbol,
            type = type
        )
    }
}
