package com.liilab.dependancyinjectionapplication.presentation.page.pixabay

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.liilab.dependancyinjectionapplication.data.datasource.remote.model.response.PixabayItemResponse
import com.liilab.dependancyinjectionapplication.data.datasource.remote.model.response.PlaceholderImageItemResponse
import com.liilab.dependancyinjectionapplication.domain.model.Resource
import com.liilab.dependancyinjectionapplication.domain.repository.PixabayRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class PixabayViewModel @Inject constructor(
    private val pixabayRepository: PixabayRepository
) : ViewModel() {

    private val _pixabayImages = MutableStateFlow<PixabayItemResponse?>(null)
    val pixabayImages: StateFlow<PixabayItemResponse?> = _pixabayImages.asStateFlow()

    private val _pixabayError = MutableStateFlow<String>("")
    val pixabayError: StateFlow<String> = _pixabayError.asStateFlow()

    fun getPixabayImageList() {

        Log.d("_xyz", "getPixabayImageList: called")
        viewModelScope.launch(Dispatchers.IO) {
            when (val response = pixabayRepository.getPixabayImageList()) {
                is Resource.Success -> _pixabayImages.value = response.data
                is Resource.Error -> _pixabayError.value = response.message.toString()
            }
        }
    }

}