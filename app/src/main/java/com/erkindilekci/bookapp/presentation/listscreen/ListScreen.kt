package com.erkindilekci.bookapp.presentation.listscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.erkindilekci.bookapp.presentation.listscreen.components.BookListScreen
import com.erkindilekci.bookapp.presentation.listscreen.components.EmptyScreen
import com.erkindilekci.bookapp.presentation.listscreen.components.ErrorScreen
import com.erkindilekci.bookapp.presentation.listscreen.components.LoadingScreen
import com.erkindilekci.bookapp.presentation.util.AppState
import com.erkindilekci.bookapp.presentation.util.MainActions

@Composable
fun ListScreen(
    viewModel: ListScreenViewModel = hiltViewModel(),
    actions: MainActions
) {
    when (val result = viewModel.appState.collectAsState().value) {
        AppState.Loading -> LoadingScreen()

        AppState.Empty -> EmptyScreen()

        is AppState.Error -> ErrorScreen(error = result.message)

        is AppState.Success -> BookListScreen(
            bookList = result.data,
            actions = actions,
            viewModel = viewModel
        )
    }
}