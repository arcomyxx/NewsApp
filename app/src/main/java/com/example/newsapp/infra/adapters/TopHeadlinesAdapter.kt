package com.example.newsapp.infra.adapters

import com.example.newsapp.domain.models.Article
import com.example.newsapp.domain.topHeadlins.TopHeadLinesPort
import com.example.newsapp.infra.models.ArticleRest
import com.example.newsapp.infra.models.toDomain
import com.example.newsapp.infra.rest.ApiClient

class TopHeadlinesAdapter : TopHeadLinesPort {
    override suspend fun getTopHeadlines(country: String): List<Article> {
        val response = ApiClient.apiService.getTopHeadlines(country = country)
        val responseBody = response.body()

        if (response.isSuccessful && responseBody != null) {
            return responseBody.articles.map(ArticleRest::toDomain)
        } else {
            throw Error(response.message())
        }
    }
}