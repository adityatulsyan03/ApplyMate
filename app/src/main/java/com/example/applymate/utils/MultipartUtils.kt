package com.example.applymate.utils

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

fun createRequestBodyFromString(value: String): RequestBody {
    return value.toRequestBody("text/plain".toMediaTypeOrNull())
}