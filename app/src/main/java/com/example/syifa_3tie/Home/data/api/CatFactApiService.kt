package com.example.syifa_3tie.Home.data.api

import com.example.syifa_3tie.Home.data.model.CatFactModel
import retrofit2.http.GET

interface CatFactApiService {
    @GET("fact")
    suspend fun getCatFact(): CatFactModel
}