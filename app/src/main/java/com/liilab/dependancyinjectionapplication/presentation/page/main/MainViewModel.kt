package com.liilab.dependancyinjectionapplication.presentation.page.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.liilab.dependancyinjectionapplication.domain.repository.MainRepository
import com.liilab.dependancyinjectionapplication.domain.model.Resource
import com.liilab.dependancyinjectionapplication.data.datasource.remote.model.response.PlaceholderImageItemResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    private val _placeholderImages = MutableStateFlow<List<PlaceholderImageItemResponse>>(emptyList())
    val placeholderImages: StateFlow<List<PlaceholderImageItemResponse>> = _placeholderImages.asStateFlow()

    private val _errorText = MutableStateFlow<String?>(null)
    val errorText: StateFlow<String?> = _errorText.asStateFlow()

    fun getPlaceholderImageList() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val response = mainRepository.getPlaceholderImageList()) {
                is Resource.Error -> {
                    _errorText.value = response.message
                }
                is Resource.Success -> {
                    _placeholderImages.value = response.data!!
                }
            }
        }
    }

}