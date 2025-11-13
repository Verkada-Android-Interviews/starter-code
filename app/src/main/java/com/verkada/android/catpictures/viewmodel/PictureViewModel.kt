package com.verkada.android.catpictures.viewmodel

import androidx.lifecycle.ViewModel
import com.verkada.android.catpictures.network.RetrofitClient
import com.verkada.android.catpictures.repository.FetchCatImagesRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PictureViewModel: ViewModel() {

    private val _picturesStateFlow = MutableStateFlow<PictureUiState>(PictureUiState.Idle)
    val stateFlow: StateFlow<PictureUiState> get() = _picturesStateFlow

    private val fetchCatImagesRepository = FetchCatImagesRepositoryImpl(RetrofitClient.api)

    suspend fun fetchCatPictures(){
        _picturesStateFlow.value = PictureUiState.Loading

        val response = fetchCatImagesRepository.fetchCatImages()

        if (response.isEmpty()) {
            _picturesStateFlow.value = PictureUiState.Idle
        } else {
            _picturesStateFlow.value = PictureUiState.Success(response)
        }
    }
}