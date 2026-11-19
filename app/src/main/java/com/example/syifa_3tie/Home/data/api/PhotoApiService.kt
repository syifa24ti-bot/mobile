package com.example.syifa_3tie.Home.data.api

import com.example.syifa_3tie.Home.data.model.PhotoModel
import retrofit2.http.GET

interface PhotoApiService {
    @GET("list")
    suspend fun getPhotos(): List<PhotoModel>
}