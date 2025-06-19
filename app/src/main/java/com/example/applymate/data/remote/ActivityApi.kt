package com.example.applymate.data.remote

import com.example.applymate.data.model.Action
import com.example.applymate.data.model.CustomResponse
import com.example.applymate.data.model.RecentActivity
import retrofit2.http.GET

interface ActivityApi {

    @GET("/recent_activity")
    suspend fun getTopTwoActivity(

    ): CustomResponse<List<RecentActivity>>

}