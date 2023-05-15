package com.example.newsapp.infra.models

import com.example.newsapp.domain.models.Article
import com.google.gson.annotations.SerializedName

enum class ResponseStatus(val value: String) {
    @SerializedName("ok")
    OK("ok"),

    @SerializedName("error")
    ERROR("error"),
}

data class NewsResponse(
    val status: ResponseStatus,
    val totalResults: Int,
    val articles: List<ArticleRest>,
)

data class ArticleRest(
    val source: SourceRest,
    val author: String,
    val title: String,
    val description: String?,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String,
)

data class SourceRest(
    val id: String,
    val name: String,
)

fun ArticleRest.toDomain() = Article(
    title = title,
    description = description,
    url = url,
    urlToImage = urlToImage,
)