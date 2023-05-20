package com.erkindilekci.bookapp.presentation.util

import androidx.navigation.NavController


class MainActions(navController: NavController) {
    val upPress: () -> Unit = {
        navController.navigateUp()
    }

    val gotoBookDetails: (String) -> Unit = { isbnNo ->
        navController.navigate("${Screen.DetailScreen.route}/$isbnNo")
    }

    val gotoBookList: () -> Unit = {
        navController.navigate(Screen.ListScreen.route)
    }
}