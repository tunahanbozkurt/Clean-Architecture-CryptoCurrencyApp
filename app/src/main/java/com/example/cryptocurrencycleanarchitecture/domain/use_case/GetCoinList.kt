package com.example.cryptocurrencycleanarchitecture.domain.use_case


import com.example.cryptocurrencycleanarchitecture.common.Resource
import com.example.cryptocurrencycleanarchitecture.data.remote.dto.CryptoCoinDto
import com.example.cryptocurrencycleanarchitecture.domain.model.CryptoCoin
import com.example.cryptocurrencycleanarchitecture.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class GetCoinList (
    private val repository:CoinRepository
) {

     fun getCoinList():Flow<Resource<List<CryptoCoin>>> {
        return repository.getDataList()
    }







}