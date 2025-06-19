package com.example.applymate.data.remote

import com.example.applymate.data.model.CustomResponse
import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface DocumentApi {

    @Multipart
    @POST("/resume")
    suspend fun getResumeText(
        //Send a PDF to the backend
        @Part document: MultipartBody.Part
    ): CustomResponse<String>

}