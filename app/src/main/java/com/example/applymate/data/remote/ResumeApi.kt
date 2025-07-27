package com.example.applymate.data.remote

import com.example.applymate.data.model.CustomResponse
import com.example.applymate.data.model.ResumeImproveText
import com.example.applymate.data.model.Suggestions
import retrofit2.http.Body
import retrofit2.http.POST

interface ResumeApi {

    @POST("/resume/improve")
    suspend fun improveResume(
        @Body resumeImproveText: ResumeImproveText
    ): CustomResponse<List<Suggestions>>

}