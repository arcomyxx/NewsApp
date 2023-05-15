package com.example.newsapp.builders

import com.example.newsapp.domain.models.Article

fun buildArticle(
    title: String = "title",
    description: String = "description",
    url: String = "url",
    urlToImage: String = "urlToImage",
) = Article(
    title = title,
    description = description,
    url = url,
    urlToImage = urlToImage,
)