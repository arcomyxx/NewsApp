package com.example.newsapp.infra.models

import com.example.newsapp.domain.models.Article

data class NewsListState(
    val articles: List<Article> = emptyList(),
    val error: String? = null
)

data class NewsDetailState(
    val article: Article? = null,
    val error: String? = null
)