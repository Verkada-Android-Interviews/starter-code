package com.verkada.android.catpictures.viewmodel

import com.verkada.android.catpictures.data.Picture

sealed class PictureUiState {
    data class Success(val pictureList: List<Picture>): PictureUiState()
    object Loading: PictureUiState()
    object Idle: PictureUiState()
    data class Error(val message: String): PictureUiState()
}