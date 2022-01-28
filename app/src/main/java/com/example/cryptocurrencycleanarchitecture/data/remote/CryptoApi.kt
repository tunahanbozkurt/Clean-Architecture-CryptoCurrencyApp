package com.example.cryptocurrencycleanarchitecture.data.remote

import com.example.cryptocurrencycleanarchitecture.data.remote.dto.CryptoCoinDto
import retrofit2.http.GET

interface CryptoApi {

    @GET("/v1/coins")
    suspend fun getCoinList():List<CryptoCoinDto>


}