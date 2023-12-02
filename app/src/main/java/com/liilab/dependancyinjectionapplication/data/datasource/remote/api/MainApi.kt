package com.liilab.dependancyinjectionapplication.data.datasource.remote.api

import com.liilab.dependancyinjectionapplication.data.datasource.remote.model.response.PlaceholderImageItemResponse
import retrofit2.Response
import retrofit2.http.GET

interface MainApi {
    @GET("/photos")
    suspend fun  getPlaceholderImageList(): Response<List<PlaceholderImageItemResponse>>
}