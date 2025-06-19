package com.example.applymate.data.model

data class CustomResponse<T>(

    var status: String,
    var message: String? = null,
    var data: T?

)