package com.example.applymate.data.remote

import com.example.applymate.data.model.Chat
import com.example.applymate.data.model.CustomResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ChatApi {

    @POST("/chat")
    suspend fun getReply(
        @Body chat: Chat
    ): CustomResponse<String>

}