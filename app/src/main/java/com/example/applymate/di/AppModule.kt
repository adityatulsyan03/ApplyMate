package com.example.applymate.di

import com.example.applymate.BuildConfig
import com.example.applymate.data.remote.ActivityApi
import com.example.applymate.data.remote.ChatApi
import com.example.applymate.data.remote.DocumentApi
import com.example.applymate.data.remote.JobSearchApi
import com.example.applymate.data.remote.ReferralApi
import com.example.applymate.data.remote.ResumeApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {

        // Logging Interceptor
        val httpLoggingInterceptor = HttpLoggingInterceptor()
            .apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

//        val authInterceptor = Interceptor { chain ->
//            val original = chain.request()
//            val token = tokenProvider.getToken()
//            val requestBuilder = original.newBuilder()
//            if (token != null) {
//                requestBuilder.addHeader("Authorization", "Bearer $token")
//            }
//            val request = requestBuilder.build()
//            chain.proceed(request)
//        }

        // HTTP Client with bearer token
        return OkHttpClient
            .Builder()
//            .addInterceptor(authInterceptor)
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun provideActivityApi(retrofit: Retrofit): ActivityApi {
        return retrofit.create(ActivityApi::class.java)
    }

    @Singleton
    @Provides
    fun provideChatApi(retrofit: Retrofit): ChatApi {
        return retrofit.create(ChatApi::class.java)
    }

    @Singleton
    @Provides
    fun provideJobSearchApi(retrofit: Retrofit): JobSearchApi {
        return retrofit.create(JobSearchApi::class.java)
    }

    @Singleton
    @Provides
    fun provideReferralApi(retrofit: Retrofit): ReferralApi {
        return retrofit.create(ReferralApi::class.java)
    }

    @Singleton
    @Provides
    fun provideResumeApi(retrofit: Retrofit): ResumeApi {
        return retrofit.create(ResumeApi::class.java)
    }
    
    @Singleton
    @Provides
    fun provideDocumentApi(retrofit: Retrofit): DocumentApi {
        return retrofit.create(DocumentApi::class.java)
    }

}