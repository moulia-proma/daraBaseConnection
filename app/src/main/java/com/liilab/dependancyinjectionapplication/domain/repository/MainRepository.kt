package com.liilab.dependancyinjectionapplication.domain.repository

import com.liilab.dependancyinjectionapplication.domain.model.Resource
import com.liilab.dependancyinjectionapplication.data.datasource.remote.model.response.PlaceholderImageItemResponse

interface MainRepository {
    suspend fun getPlaceholderImageList(): Resource<List<PlaceholderImageItemResponse>>
}