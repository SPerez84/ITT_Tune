package com.example.itt_tune.network

import kotlinx.serialization.Serializable


@Serializable
data class translations (
    val id:String,
    val traduccion: String
)