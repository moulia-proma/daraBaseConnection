package com.liilab.dependancyinjectionapplication.data.repository

import android.util.Log
import com.liilab.dependancyinjectionapplication.data.datasource.remote.api.MainApi
import com.liilab.dependancyinjectionapplication.data.datasource.remote.api.PixabayApi
import com.liilab.dependancyinjectionapplication.data.datasource.remote.model.response.PixabayItemResponse
import com.liilab.dependancyinjectionapplication.domain.model.Resource
import com.liilab.dependancyinjectionapplication.domain.repository.PixabayRepository
import javax.inject.Inject

class PixabayRepositoryImpl @Inject constructor(private val pixabayAPi: PixabayApi) :
    PixabayRepository {

    override suspend fun getPixabayImageList(): Resource<PixabayItemResponse> {

        Log.d("_xyz", "getPixabayImageList: PixabayRepositoryImpl called")

        return try {
            val response = pixabayAPi.getPixabayImageList(
                key = "14846267-ffddff5786ff48bf9e830e407",
                imageType = "photo"
            )
            val pixabayImages = response.body()
            if (response.isSuccessful && pixabayImages != null) {
                Log.d("_xyz","$pixabayImages")
                Resource.Success(pixabayImages)
            } else {
                Log.d("_xyz","deg")
                Resource.Error("Error occurred")

            }

        } catch (e: Exception) {
            Log.d("_xyz","${e.message}")
            Resource.Error("Error occurred")
        }

    }

}