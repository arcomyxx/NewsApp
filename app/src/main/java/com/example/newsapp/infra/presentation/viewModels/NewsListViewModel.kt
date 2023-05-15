package com.example.newsapp.infra.presentation.viewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.newsapp.domain.models.Resource
import com.example.newsapp.domain.topHeadlins.GetTopHeadlines
import com.example.newsapp.infra.adapters.TopHeadlinesAdapter
import com.example.newsapp.infra.models.NewsListState

class NewsListViewModel : ViewModel() {
    private val adapter = TopHeadlinesAdapter()
    private val getTopHeadlines = GetTopHeadlines(adapter)

    private val _state = mutableStateOf(NewsListState())
    val state: State<NewsListState> = _state

    init {
        getArticles()
    }

    private fun getArticles() {
        val resource = getTopHeadlines()

        _state.value = when (resource) {
            is Resource.Success -> NewsListState(articles = resource.data ?: emptyList())
            is Resource.Error -> NewsListState(error = resource.message)
        }
    }
}