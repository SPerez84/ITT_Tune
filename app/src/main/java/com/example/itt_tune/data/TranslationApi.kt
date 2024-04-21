package com.example.itt_tune.data

import android.view.translation.TranslationRequest
import android.view.translation.TranslationResponse
import com.example.itt_tune.network.translations
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface TranslationApi {
    @POST("translate")
    suspend fun translateText(
        @Body request: TranslationRequest
    ): TranslationResponse
}
interface TranslatorApiService {
    @GET("/translate?api-version=3.0&from=en&to=fr&to=zu")
    suspend fun getTranslation(@Query("q") userInput: String): List<translations>
}