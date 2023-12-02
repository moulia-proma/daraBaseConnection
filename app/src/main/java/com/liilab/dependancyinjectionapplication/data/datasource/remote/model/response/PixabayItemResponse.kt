package com.liilab.dependancyinjectionapplication.data.datasource.remote.model.response

data class PixabayItemResponse(
    val hits: List<Hit>,
    val total: Int,
    val totalHits: Int
)