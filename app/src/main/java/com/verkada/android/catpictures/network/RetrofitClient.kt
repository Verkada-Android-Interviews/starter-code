package com.verkada.android.catpictures.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    fun createRetrofitClient(): Retrofit {
        val gsonConverterFactory = GsonConverterFactory.create()
        return Retrofit
            .Builder()
            .baseUrl(PictureService.ROOT_URL)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    val api by lazy { createRetrofitClient().create(PictureService::class.java) }
}