package com.example.newsapp.domain.topHeadlins

import com.example.newsapp.domain.models.Article

interface TopHeadLinesPort {
    suspend fun getTopHeadlines(country: String): List<Article>
}