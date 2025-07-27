package com.example.applymate.data.remote

import com.example.applymate.data.model.CustomResponse
import com.example.applymate.data.model.ResumeText
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface DocumentApi {

    @Multipart
    @POST("/document")
    suspend fun getDocumentText(
        //Send a PDF to the backend
        @Part document: MultipartBody.Part,
        @Part("type") type: RequestBody,
        @Part("prompt") prompt: RequestBody,
        @Part("txt") txt: RequestBody
    ): CustomResponse<ResumeText>

}