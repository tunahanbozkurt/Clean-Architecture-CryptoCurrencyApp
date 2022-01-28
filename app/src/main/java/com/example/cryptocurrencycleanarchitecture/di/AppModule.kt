package com.example.cryptocurrencycleanarchitecture.di


import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.cryptocurrencycleanarchitecture.common.Constants.BASE_URL
import com.example.cryptocurrencycleanarchitecture.data.local.CryptoDatabase
import com.example.cryptocurrencycleanarchitecture.data.remote.CryptoApi
import com.example.cryptocurrencycleanarchitecture.data.remote.RemoteDataSourceImpl
import com.example.cryptocurrencycleanarchitecture.data.repository.CoinRepositoryImpl
import com.example.cryptocurrencycleanarchitecture.domain.data_source.RemoteDataSource
import com.example.cryptocurrencycleanarchitecture.domain.repository.CoinRepository
import com.example.cryptocurrencycleanarchitecture.domain.use_case.GetCoinList
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Singleton
    @Provides
    fun provideApi():CryptoApi{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(CryptoApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(
        dataSource:RemoteDataSource,
        db:CryptoDatabase
    ):CoinRepository{
        return CoinRepositoryImpl(dataSource,db.cryptoDao)
    }

    @Singleton
    @Provides
    fun provideRemoteDS(api:CryptoApi):RemoteDataSource{
        return RemoteDataSourceImpl(api)
    }

    @Singleton
    @Provides
    fun provideCoinListUseCase(repository:CoinRepository):GetCoinList{
        return GetCoinList(repository)
    }


    @Provides
    @Singleton
    fun provideDatabase(app: Application): CryptoDatabase {
        return Room.databaseBuilder(
            app, CryptoDatabase::class.java, "crypto_db"
        ).build()
    }







}