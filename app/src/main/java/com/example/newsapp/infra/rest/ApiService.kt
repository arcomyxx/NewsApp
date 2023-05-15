package com.example.newsapp.infra.rest

import com.example.newsapp.infra.models.NewsResponse
import com.example.newsapp.infra.rest.ApiClient.API_KEY
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String = API_KEY,
    ): Response<NewsResponse>
}
