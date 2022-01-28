package com.example.cryptocurrencycleanarchitecture.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CryptoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(cryptoEntity: List<CryptoEntity>)

    @Query("SELECT * FROM cryptoentity")
    suspend fun getAll(): List<CryptoEntity>

    @Query("DELETE FROM cryptoentity")
    suspend fun deleteAll()
}