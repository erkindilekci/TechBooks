package com.erkindilekci.bookapp.presentation.detailscreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.erkindilekci.bookapp.presentation.detailscreen.components.BookDetailCard
import com.erkindilekci.bookapp.presentation.detailscreen.components.BookDetailScaffold
import com.erkindilekci.bookapp.presentation.listscreen.components.BookListScreen
import com.erkindilekci.bookapp.presentation.listscreen.components.EmptyScreen
import com.erkindilekci.bookapp.presentation.listscreen.components.ErrorScreen
import com.erkindilekci.bookapp.presentation.listscreen.components.LoadingScreen
import com.erkindilekci.bookapp.presentation.util.AppState
import com.erkindilekci.bookapp.presentation.util.DetailState
import com.erkindilekci.bookapp.presentation.util.MainActions

@Composable
fun DetailScreen(
    viewModel: DetailScreenViewModel = hiltViewModel(),
    actions: MainActions,
    isbnNo: String
) {
    LaunchedEffect(key1 = true) {
        viewModel.getSelectedBook(isbnNo)
    }

    when (val result = viewModel.appState.collectAsState().value) {
        DetailState.Loading -> LoadingScreen()

        DetailState.Empty -> EmptyScreen()

        is DetailState.Error -> ErrorScreen(error = result.message)

        is DetailState.Success -> BookDetailScaffold(book = result.data, onBackCLicked = { actions.upPress.invoke() })
    }
}