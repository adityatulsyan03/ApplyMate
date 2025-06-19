package com.example.applymate.data.repository

import com.example.applymate.common.UiState
import com.example.applymate.data.model.Chat
import com.example.applymate.data.model.CustomResponse
import com.example.applymate.data.remote.ChatApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ChatRepository @Inject constructor(
    private val chatApi: ChatApi
){

    suspend fun getReply(chats: List<Chat>): Flow<UiState<CustomResponse<String>>> = flow {

        try{
            emit(UiState.Loading)

            val response = chatApi.getReply(chats)

            if(response.status == "OK"){
                 emit(UiState.Success(response,"Reply fetched"))
            }else{
                emit(UiState.Failed(response.message ?: "Failed to Fetched"))
            }
        } catch (e: Exception){
            emit(UiState.Failed(e.message ?: "An Unexpected Error Occurred"))
        }

    }

}