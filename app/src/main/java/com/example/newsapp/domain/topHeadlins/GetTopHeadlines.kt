package com.example.newsapp.domain.topHeadlins

import com.example.newsapp.domain.models.Article
import com.example.newsapp.domain.models.Resource
import kotlinx.coroutines.runBlocking
import java.util.Locale

class GetTopHeadlines(
    private val adapter: TopHeadLinesPort,
) {
    operator fun invoke(): Resource<List<Article>> = runBlocking {
        try {
            val articles = adapter.getTopHeadlines(
                country = Locale.getDefault().language,
                //country = "us",
            )
            Resource.Success(articles)
        } catch (e: Exception) {
            Resource.Error(e.message ?: "unknown error")
        }
    }
}