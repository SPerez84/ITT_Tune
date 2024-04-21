package com.example.itt_tune.data

import com.example.itt_tune.network.translations
import com.example.itt_tune.network.translatorApiService

interface ITT_TuneRepository {
    suspend fun getAzureResponse(userInput: String): List<translations>

}

class NetworkITT_TuneRepository(
    private val ittTranslatorApiService: translatorApiService
) : ITT_TuneRepository {
    override suspend fun getAzureResponse(userInput: String): List<translations> =
        ittTranslatorApiService.getTranslation(userInput)
}