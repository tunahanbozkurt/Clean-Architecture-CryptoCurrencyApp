package com.example.cryptocurrencycleanarchitecture.data.remote

import com.example.cryptocurrencycleanarchitecture.data.remote.dto.CryptoCoinDto
import com.example.cryptocurrencycleanarchitecture.domain.data_source.RemoteDataSource
import javax.inject.Inject


class RemoteDataSourceImpl(
    private val api:CryptoApi
):RemoteDataSource {

    override suspend fun getDataList(): List<CryptoCoinDto> {
        return api.getCoinList()
    }


}













