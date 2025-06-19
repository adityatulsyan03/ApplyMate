package com.example.applymate.data.remote

import com.example.applymate.data.model.CustomResponse
import com.example.applymate.data.model.Referral
import retrofit2.http.Body
import retrofit2.http.POST

interface ReferralApi {

    @POST("/referral")
    suspend fun getReferralMsg(
        @Body referral: Referral
    ): CustomResponse<String>

}