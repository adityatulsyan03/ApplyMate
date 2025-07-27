package com.example.applymate.data.repository

import android.util.Log
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

    suspend fun getReply(chats: List<String>, documentText: String): Flow<UiState<CustomResponse<String>>> = flow {

        try{
            emit(UiState.Loading)

            val chat = Chat(
                messages = chats,
                userName = "User",
                role = "SDE",
                documentText = documentText
            )
            val response = chatApi.getReply(chat)

            if(response.status == "OK"){
                 emit(UiState.Success(response,"Reply fetched"))
                Log.d("Debug Logs","UiState Success")
            }else{
                emit(UiState.Failed(response.message ?: "Failed to Fetched"))
                Log.d("Debug Logs","UiState Failed")
            }
        } catch (e: Exception){
            emit(UiState.Failed(e.message ?: "An Unexpected Error Occurred"))
            Log.d("Debug Logs","UiState Error $e")
        }

    }

}