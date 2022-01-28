package com.example.cryptocurrencycleanarchitecture.data.repository

import com.example.cryptocurrencycleanarchitecture.common.Resource
import com.example.cryptocurrencycleanarchitecture.data.local.CryptoDao
import com.example.cryptocurrencycleanarchitecture.data.remote.CryptoApi
import com.example.cryptocurrencycleanarchitecture.data.remote.RemoteDataSourceImpl
import com.example.cryptocurrencycleanarchitecture.data.remote.dto.CryptoCoinDto
import com.example.cryptocurrencycleanarchitecture.domain.data_source.RemoteDataSource
import com.example.cryptocurrencycleanarchitecture.domain.model.CryptoCoin
import com.example.cryptocurrencycleanarchitecture.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class CoinRepositoryImpl (
    private val dataSource:RemoteDataSource,
    private val dao: CryptoDao
):CoinRepository {

    override fun getDataList(): Flow<Resource<List<CryptoCoin>>> = flow {
        emit(Resource.Loading<List<CryptoCoin>>())

        val cacheData = dao.getAll().map { it.toCryptoCoin() }
        emit(Resource.Loading<List<CryptoCoin>>(cacheData))

        try {
            val remoteData = dataSource.getDataList().map { it.toCryptoEntity() }
            dao.deleteAll()
            dao.insertAll(remoteData)
        }
        catch (e:IOException){
            emit(Resource.Error<List<CryptoCoin>>(
                message = "Oops, something went wrong!"))
        }
        catch (e:HttpException){
            emit(Resource.Error<List<CryptoCoin>>(
                message = "Couldn't reach server, check your internet connection."))
        }
        val newData = dao.getAll().map { it.toCryptoCoin() }
        emit(Resource.Success<List<CryptoCoin>>(newData))


    }




}