package com.example.applymate.data.remote

import com.example.applymate.data.model.CustomResponse
import com.example.applymate.data.model.JobSearch
import retrofit2.http.Body
import retrofit2.http.POST

interface JobSearchApi {

    @POST("/job_search")
    suspend fun getJobQuery(
        @Body jobSearch: JobSearch
    ): CustomResponse<String>

}