package com.example.itt_tune.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL =
    "https://portal.azure.com/#create/Microsoft.CognitiveServicesTextTranslation"

private val speechServiceAzure = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()


private const val speechServiceKey :String = " "

private const val speechServiceRegion :String = " "

interface speechServiceApi {
    @GET("photos")
    suspend fun getPhotos(): List<translations>
}

object speechApi {
    val speechService : speechServiceApi by lazy {
        speechServiceAzure.create(speechServiceApi::class.java)
    }
}