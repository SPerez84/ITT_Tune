package com.example.itt_tune.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL =
    "https://portal.azure.com/#create/Microsoft.CognitiveServicesTextTranslation"

private val computerVisionAzure = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()


private const val computerVisionKey :String = " "

private const val computerVisionRegion :String = " "

interface computerVisionApi {
    @GET("photos")
    suspend fun getPhotos(): List<translations>
}

object computerVision {
    val computerVisionService : computerVisionApi by lazy {
        computerVisionAzure.create(computerVisionApi::class.java)
    }
}