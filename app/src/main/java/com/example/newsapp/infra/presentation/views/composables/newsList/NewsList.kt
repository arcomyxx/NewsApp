package com.example.newsapp.infra.presentation.views.composables.newsList

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.newsapp.infra.presentation.viewModels.NewsListViewModel
import com.example.newsapp.infra.presentation.views.composables.common.Error

@Composable
fun NewsList(
    navController: NavController,
    viewModel: NewsListViewModel = NewsListViewModel(),
) {
    val state = viewModel.state.value

    if (state.articles.isNotEmpty()) {
        LazyColumn {
            items(state.articles) { article ->
                NewsListItem(article, navController)
            }
        }
    } else if (state.error != null) {
        Error(message = state.error)
    } else {
        Text(text = "Aucun article")
    }
}
