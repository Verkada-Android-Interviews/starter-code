package com.verkada.android.catpictures

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.verkada.android.catpictures.data.Picture
import com.verkada.android.catpictures.viewmodel.PictureUiState
import com.verkada.android.catpictures.viewmodel.PictureViewModel

@Composable
fun GalleryScreen(viewModel: PictureViewModel) {
    val pictures by viewModel.stateFlow.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchCatPictures()
    }

    when (val state = pictures) {
        is PictureUiState.Loading -> { Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(modifier = Modifier.size(50.dp), color = Color.Blue, strokeWidth = 3.dp)
        }}
        is PictureUiState.Success -> {
            GalleryGrid(state.pictureList)
        }
        is PictureUiState.Error -> { }
        is PictureUiState.Idle -> { }
    }

}

@Composable
fun GalleryGrid(pictureList: List<Picture>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.fillMaxSize()
    ) {
        items(pictureList, key = { it.id }) { picture ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.size(96.dp)
            ) {
                AsyncImage(
                    model = picture.url,
                    contentDescription = "cat picture",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}