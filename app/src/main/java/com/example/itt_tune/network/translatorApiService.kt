package com.example.itt_tune.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query



private const val translatorKey :String = "7a35de61b98f4b3796fba8757b1ae714 "

private const val translatorRegion :String = " westus"

interface TranslatorApiService {
    @GET("/translate")
    suspend fun getTranslation(
        @Header("Ocp-Apim-Subscription-Key") subscriptionKey: String =translatorKey,
        @Header("Ocp-Apim-Subscription-Region") subscriptionRegion: String = translatorRegion,
        @Query("api-version") apiVersion: String = "3.0",
        @Query("from") from: String = "en",
        @Query("to") to: String = "fr,zu",
        @Query("q") userInput: String
    ): List<translations>
}

/*object translatorApi {


}

private const val baseUrl =
    "https://portal.azure.com/#create/Microsoft.CognitiveServicesTextTranslation/"

val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(baseUrl)
    .build()
*/
