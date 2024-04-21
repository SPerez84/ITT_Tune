package com.example.itt_tune.network

import kotlinx.serialization.Serializable


@Serializable
data class translations (
    val traduccion: String,
    val idiomaOrigen : String,
    val idiomaFinal : String
)

@Serializable
data class Request(
    val translatedText : String
)
