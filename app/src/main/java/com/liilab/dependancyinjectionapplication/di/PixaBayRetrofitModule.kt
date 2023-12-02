package com.liilab.dependancyinjectionapplication.di

import com.liilab.dependancyinjectionapplication.data.datasource.remote.api.PixabayApi
import com.liilab.dependancyinjectionapplication.data.repository.PixabayRepositoryImpl
import com.liilab.dependancyinjectionapplication.domain.repository.PixabayRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object PixaBayRetrofitModule {
    var baseUrl = "https://pixabay.com/"

    @Singleton
    @Provides
    fun getPixabayImageList(): PixabayApi {
        return Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
            .create(PixabayApi::class.java)
    }

}