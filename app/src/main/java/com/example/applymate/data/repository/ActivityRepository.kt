package com.example.applymate.data.repository

import com.example.applymate.common.UiState
import com.example.applymate.data.model.CustomResponse
import com.example.applymate.data.model.RecentActivity
import com.example.applymate.data.remote.ActivityApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ActivityRepository @Inject constructor(
    private val actionApi: ActivityApi
) {

    suspend fun getTopTwoActivity(): Flow<UiState<CustomResponse<List<RecentActivity>>>> = flow {
        try{

            emit(UiState.Loading)
            val response = actionApi.getTopTwoActivity();
            if(response.status == "OK"){
                emit(UiState.Success(response,"Top Two Activity Fetched"))
            }else{
                emit(UiState.Failed(response.message ?: "Failed to Fetched"))
            }

        } catch (e: Exception) {

            emit(UiState.Failed(e.message ?: "An unexpected Error Occurred"))

        }
    }

}