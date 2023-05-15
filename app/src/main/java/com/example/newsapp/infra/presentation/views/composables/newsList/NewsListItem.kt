package com.example.newsapp.infra.presentation.views.composables.newsList

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.newsapp.domain.models.Article
import com.example.newsapp.infra.presentation.navigation.Screen

@Composable
fun NewsListItem(
    article: Article,
    navController: NavController,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clickable {
                navController.navigate(Screen.NewsDetails.route + "?url=" + article.url)
            },
        elevation = CardDefaults.cardElevation(10.dp),
    ) {
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Text(
                text = article.title,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                ),
            )
            article.urlToImage?.let {
                Image(
                    painter = rememberAsyncImagePainter(it),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
    }
}