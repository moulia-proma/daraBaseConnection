package com.liilab.dependancyinjectionapplication.data.datasource.remote.api

import com.liilab.dependancyinjectionapplication.data.datasource.remote.model.response.PixabayItemResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApi {
    @GET("api/")
    suspend fun getPixabayImageList(
        @Query("key") key: String,
        @Query("image_type") imageType: String
    ): Response<PixabayItemResponse>
}