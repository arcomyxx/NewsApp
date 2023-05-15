package com.example.newsapp.infra.presentation.views.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.newsapp.infra.presentation.viewModels.NewsDetailsViewModel
import com.example.newsapp.infra.presentation.views.composables.common.Error

@Composable
fun NewsDetails(
    url: String?,
    viewModel: NewsDetailsViewModel = NewsDetailsViewModel(),
) {
    url?.let { viewModel.getArticle(it) }
    val state = viewModel.state.value
    val article = state.article
    val uriHandler = LocalUriHandler.current

    if (article != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
        ) {
            Text(
                text = article.title,
                style = TextStyle(
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                ),
                modifier = Modifier.padding(15.dp),
            )
            article.urlToImage?.let {
                Image(
                    painter = rememberAsyncImagePainter(it),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                )
            }
            article.description?.let {
                Text(
                    text = it,
                    style = TextStyle(
                        fontSize = 16.sp,
                    ),
                    modifier = Modifier.padding(15.dp),
                )
            }
            Button(
                onClick = {
                    uriHandler.openUri(article.url)
                },
            ) {
                Text(text = "Ouvrir l'article")
            }
        }
    } else if (state.error != null) {
        Error(message = state.error)
    } else {
        Text("Article non trouvé")
    }
}