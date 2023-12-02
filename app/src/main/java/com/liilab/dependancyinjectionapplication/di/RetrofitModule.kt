package com.liilab.dependancyinjectionapplication.di

import com.liilab.dependancyinjectionapplication.data.datasource.remote.api.MainApi
import com.liilab.dependancyinjectionapplication.domain.repository.MainRepository
import com.liilab.dependancyinjectionapplication.data.repository.MainRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton



@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    private const val baseUrl = "https://jsonplaceholder.typicode.com/"
    @Singleton
    @Provides
    fun provideAPi(): MainApi = Retrofit
        .Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MainApi::class.java)

    @Singleton
    @Provides
    fun provideRepository(imageUrl: MainApi): MainRepository = MainRepositoryImpl(imageUrl)

}





