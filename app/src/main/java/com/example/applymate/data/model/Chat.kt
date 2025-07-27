package com.example.applymate.data.model

data class Chat(

    val messages: List<String>,
    val userName: String,
    val role: String,
    val documentText: String

)