package com.verkada.android.catpictures

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Text
import com.verkada.android.catpictures.theme.CatPicturesTheme
import com.verkada.android.catpictures.viewmodel.PictureViewModel

class MainComposeActivity : ComponentActivity() {
    private val viewModel by viewModels<PictureViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CatPicturesTheme {
                GalleryScreen(viewModel)
            }
        }
    }
}
