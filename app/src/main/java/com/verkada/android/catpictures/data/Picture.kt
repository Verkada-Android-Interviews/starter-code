package com.verkada.android.catpictures.data


import com.google.gson.annotations.SerializedName

data class Picture (
    @SerializedName("id")
    val id: String,
    @SerializedName("download_url")
    val url: String,
)
