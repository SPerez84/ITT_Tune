package com.example.itt_tune.data

import com.example.itt_tune.network.translatorApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val ittTunerepository : ITT_TuneRepository
}

class DefaultAppContainer : AppContainer {
    private val baseUrl = "https://api.cognitive.microsofttranslator.com/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val retrofitService: TranslatorApiService by lazy {
        retrofit.create(TranslatorApiService::class.java)
    }
    override val ittTunerepository: ITT_TuneRepository by lazy {
        NetworkITT_TuneRepository(retrofitService)
    }
}
