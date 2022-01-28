package com.example.cryptocurrencycleanarchitecture.domain.data_source

import com.example.cryptocurrencycleanarchitecture.data.remote.dto.CryptoCoinDto
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    suspend fun getDataList(): List<CryptoCoinDto>
}