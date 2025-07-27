package com.example.applymate.data.repository

import android.util.Log
import com.example.applymate.common.UiState
import com.example.applymate.data.model.CustomResponse
import com.example.applymate.data.model.JobSearch
import com.example.applymate.data.remote.JobSearchApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class JobSearchRepository @Inject constructor(
    private val jobSearchApi: JobSearchApi
){

    suspend fun getJobQuery(jobSearch: JobSearch): Flow<UiState<CustomResponse<String>>> = flow {

        try{
            emit(UiState.Loading)

            val response = jobSearchApi.getJobQuery(jobSearch)

            if(response.status == "OK"){
                emit(UiState.Success(response,"Query fetched"))
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