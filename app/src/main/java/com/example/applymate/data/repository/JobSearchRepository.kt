package com.example.applymate.data.repository

import com.example.applymate.common.UiState
import com.example.applymate.data.model.Chat
import com.example.applymate.data.model.CustomResponse
import com.example.applymate.data.model.JobSearch
import com.example.applymate.data.remote.JobSearchApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class JobSearchRepository @Inject constructor(
    private val jobSearchApi: JobSearchApi
){

    suspend fun getJobQuery(jobQuery: JobSearch): Flow<UiState<CustomResponse<String>>> = flow {

        try{
            emit(UiState.Loading)

            val response = jobSearchApi.getJobQuery(jobQuery)

            if(response.status == "OK"){
                emit(UiState.Success(response,"Query fetched"))
            }else{
                emit(UiState.Failed(response.message ?: "Failed to Fetched"))
            }
        } catch (e: Exception){
            emit(UiState.Failed(e.message ?: "An Unexpected Error Occurred"))
        }

    }

}