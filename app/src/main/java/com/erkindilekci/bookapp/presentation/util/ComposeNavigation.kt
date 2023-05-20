package com.erkindilekci.bookapp.presentation.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.erkindilekci.bookapp.presentation.detailscreen.DetailScreen
import com.erkindilekci.bookapp.presentation.listscreen.ListScreen

@Composable
fun ComposeNavigation() {
    val navController = rememberNavController()
    val actions = remember(navController) { MainActions(navController) }

    NavHost(navController = navController, startDestination = Screen.ListScreen.route) {
        composable(Screen.ListScreen.route) {
            ListScreen(actions = actions)
        }
        composable(
            route = "${Screen.DetailScreen.route}/{id}",
            arguments = listOf(
                navArgument(name = "id") {
                    type = NavType.StringType
                }
            )
        ) {
            val id = it.arguments?.getString("id")
                ?: throw IllegalStateException("Book ISBN No should not be null!")
            DetailScreen(actions = actions, isbnNo = id)
        }
    }
}