package com.verkada.android.catpictures.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.verkada.android.catpictures.network.RetrofitClient
import com.verkada.android.catpictures.repository.FetchCatImagesRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PictureViewModel: ViewModel() {

    private val _picturesStateFlow = MutableStateFlow<PictureUiState>(PictureUiState.Idle)
    val stateFlow: StateFlow<PictureUiState> get() = _picturesStateFlow

    private val fetchCatImagesRepository = FetchCatImagesRepositoryImpl(RetrofitClient.api)

    fun fetchCatPictures(){
        _picturesStateFlow.value = PictureUiState.Loading

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val response = fetchCatImagesRepository.fetchCatImages()

                if (response.isEmpty()) {
                    _picturesStateFlow.value = PictureUiState.Idle
                } else {
                    _picturesStateFlow.value = PictureUiState.Success(response)
                }
            }
        }
    }
}