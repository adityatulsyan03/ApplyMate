package com.example.applymate.data.repository

import android.util.Log
import com.example.applymate.common.UiState
import com.example.applymate.data.model.CustomResponse
import com.example.applymate.data.model.Referral
import com.example.applymate.data.remote.ReferralApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ReferralRepository @Inject constructor(
    private val referralApi: ReferralApi
){

    suspend fun getReferralMsg(referralContent: Referral): Flow<UiState<CustomResponse<String>>> = flow {

        try{
            emit(UiState.Loading)

            val response = referralApi.getReferralMsg(referralContent)

            if(response.status == "OK"){
                emit(UiState.Success(response,"Referral Message fetched"))
                Log.d("Debug Logs","UiState Success")
            }else{
                emit(UiState.Failed(response.message ?: "Failed to Fetched"))
                Log.d("Debug Logs","UiState Failed")
            }
        } catch (e: Exception){
            emit(UiState.Failed(e.message ?: "An Unexpected Error Occurred"))
            Log.d("Debug Logs","UiState Exception $e")
        }

    }

}