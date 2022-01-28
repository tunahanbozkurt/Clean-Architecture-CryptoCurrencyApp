package com.example.cryptocurrencycleanarchitecture.domain.repository

import com.example.cryptocurrencycleanarchitecture.common.Resource
import com.example.cryptocurrencycleanarchitecture.data.remote.dto.CryptoCoinDto
import com.example.cryptocurrencycleanarchitecture.domain.model.CryptoCoin
import kotlinx.coroutines.flow.Flow

interface CoinRepository {

     fun getDataList(): Flow<Resource<List<CryptoCoin>>>
}