package com.verkada.android.catpictures.repository

import com.verkada.android.catpictures.data.Picture
import com.verkada.android.catpictures.network.PictureService

interface FetchCatImagesRepository {
    suspend fun fetchCatImages(): List<Picture>
}

class FetchCatImagesRepositoryImpl(
    private val api: PictureService
): FetchCatImagesRepository {
    override suspend fun fetchCatImages(): List<Picture> {
        return api.pictures(1)
    }
}