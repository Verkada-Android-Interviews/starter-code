package com.verkada.android.catpictures.network

import com.verkada.android.catpictures.data.Picture
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PictureService {

    @GET("list")
    suspend fun pictures(
        @Query("page") page: Int = 1,
        @Query("limit") perPage: Int = PER_PAGE_COUNT
    ): List<Picture>

    companion object {
        private const val PER_PAGE_COUNT = 30
        const val ROOT_URL = "https://picsum.photos/v2/"
    }
}
