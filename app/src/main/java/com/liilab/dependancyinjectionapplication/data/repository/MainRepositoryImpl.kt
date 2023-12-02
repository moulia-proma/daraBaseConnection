package com.liilab.dependancyinjectionapplication.data.repository

import com.liilab.dependancyinjectionapplication.domain.repository.MainRepository
import com.liilab.dependancyinjectionapplication.data.datasource.remote.api.MainApi
import com.liilab.dependancyinjectionapplication.domain.model.Resource
import com.liilab.dependancyinjectionapplication.data.datasource.remote.model.response.PlaceholderImageItemResponse
import java.lang.Exception
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val imageApi: MainApi
) : MainRepository {

    override suspend fun getPlaceholderImageList(): Resource<List<PlaceholderImageItemResponse>> {
        return try {
            val response = imageApi.getPlaceholderImageList()
            val data: List<PlaceholderImageItemResponse>? = response.body()
            if (response.isSuccessful && data != null) {
                Resource.Success(data)
            } else {
                Resource.Error("Error occurred")
            }
        } catch (e: Exception) {
            Resource.Error("Error occurred")
        }
    }
}