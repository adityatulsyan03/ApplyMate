package com.example.applymate.data.repository

import com.example.applymate.common.UiState
import com.example.applymate.data.model.Chat
import com.example.applymate.data.model.CustomResponse
import com.example.applymate.data.model.ResumeText
import com.example.applymate.data.model.Suggestions
import com.example.applymate.data.remote.ResumeApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ResumeRepository @Inject constructor(
    private val resumeApi: ResumeApi
){

    suspend fun improveResume(resumeText: ResumeText): Flow<UiState<CustomResponse<List<Suggestions>>>> = flow {

        try{
            emit(UiState.Loading)

            val response = resumeApi.improveResume(resumeText)

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