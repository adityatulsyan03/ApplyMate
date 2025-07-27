package com.example.applymate.data.repository

import android.util.Log
import com.example.applymate.common.UiState
import com.example.applymate.data.model.CustomResponse
import com.example.applymate.data.model.ResumeText
import com.example.applymate.data.remote.DocumentApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

class DocumentRepository @Inject constructor(
    private val documentApi: DocumentApi
){

    suspend fun getDocumentText(
        document: MultipartBody.Part,
        type: RequestBody,
        prompt: RequestBody,
        txt: RequestBody
    ): Flow<UiState<CustomResponse<ResumeText>>> = flow {

        try{
            emit(UiState.Loading)

            val response = documentApi.getDocumentText(document, type, prompt, txt)

            if(response.status == "OK"){
                emit(UiState.Success(data = response, message = "Text Fetched"))
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