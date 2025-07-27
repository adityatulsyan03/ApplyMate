package com.example.applymate.data.repository

import android.util.Log
import com.example.applymate.common.UiState
import com.example.applymate.data.model.CustomResponse
import com.example.applymate.data.model.ResumeImproveText
import com.example.applymate.data.model.ResumeText
import com.example.applymate.data.model.Suggestions
import com.example.applymate.data.remote.ResumeApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ResumeRepository @Inject constructor(
    private val resumeApi: ResumeApi
){

    suspend fun improveResume(resumeImproveText: ResumeImproveText): Flow<UiState<CustomResponse<List<Suggestions>>>> = flow {

        try{
            emit(UiState.Loading)

            val response = resumeApi.improveResume(resumeImproveText)

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