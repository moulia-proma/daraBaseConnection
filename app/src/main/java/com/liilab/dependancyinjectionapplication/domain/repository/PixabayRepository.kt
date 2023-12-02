package com.liilab.dependancyinjectionapplication.domain.repository

import com.liilab.dependancyinjectionapplication.data.datasource.remote.model.response.PixabayItemResponse
import com.liilab.dependancyinjectionapplication.domain.model.Resource

interface PixabayRepository {

    suspend fun getPixabayImageList(): Resource<PixabayItemResponse>
}