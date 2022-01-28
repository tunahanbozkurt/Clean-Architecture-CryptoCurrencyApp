package com.example.cryptocurrencycleanarchitecture.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CryptoEntity::class], version = 1)
abstract class CryptoDatabase:RoomDatabase() {
    abstract val cryptoDao: CryptoDao

}