package com.example.applymate.data.repository

import com.example.applymate.common.UiState
import com.example.applymate.data.model.Chat
import com.example.applymate.data.model.CustomResponse
import com.example.applymate.data.remote.DocumentApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.MultipartBody
import javax.inject.Inject

class DocumentRepository @Inject constructor(
    private val documentApi: DocumentApi
){

    suspend fun getResumeText(document: MultipartBody.Part): Flow<UiState<CustomResponse<String>>> = flow {

        try{
            emit(UiState.Loading)

            val response = documentApi.getResumeText(document)

            if(response.status == "OK"){
                emit(UiState.Success(response,"Text fetched"))
            }else{
                emit(UiState.Failed(response.message ?: "Failed to Fetched"))
            }
        } catch (e: Exception){
            emit(UiState.Failed(e.message ?: "An Unexpected Error Occurred"))
        }

    }

}