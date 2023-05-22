package com.verkada.android.catpictures

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import com.verkada.android.catpictures.theme.CatPicturesTheme

class MainComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CatPicturesTheme {
                Text(text = "Hello world!")
            }
        }
    }
}
