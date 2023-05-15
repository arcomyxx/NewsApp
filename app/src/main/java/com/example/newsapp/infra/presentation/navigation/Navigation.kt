package com.example.newsapp.infra.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.newsapp.infra.presentation.views.composables.NewsDetails
import com.example.newsapp.infra.presentation.views.composables.newsList.NewsList

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.NewsList.route) {
        composable(route = Screen.NewsList.route) {
            NewsList(navController = navController)
        }

        val urlArg = "url"
        composable(
            route = "${Screen.NewsDetails.route}?url={$urlArg}",
            arguments = listOf(
                navArgument(urlArg) {
                    type = NavType.StringType
                }
            )
        ) {
            NewsDetails(url = it.arguments?.getString(urlArg))
        }
    }
}