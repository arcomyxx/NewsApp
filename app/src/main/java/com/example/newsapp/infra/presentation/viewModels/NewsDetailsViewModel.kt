package com.example.newsapp.infra.presentation.viewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.example.newsapp.infra.models.NewsDetailState

class NewsDetailsViewModel {
    private val newsListViewModel = NewsListViewModel()

    private val _state = mutableStateOf(NewsDetailState())
    val state: State<NewsDetailState> = _state

    fun getArticle(url: String) {
        val article = newsListViewModel.state.value.articles.find { article ->
            article.url == url
        }

        if (article != null) {
            _state.value = NewsDetailState(article = article)
        } else {
            _state.value = NewsDetailState(error = "article not found")
        }
    }
}