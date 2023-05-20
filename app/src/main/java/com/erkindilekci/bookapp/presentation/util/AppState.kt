package com.erkindilekci.bookapp.presentation.util

import com.erkindilekci.bookapp.domain.model.Book

sealed class AppState {
    object Empty : AppState()
    object Loading : AppState()
    data class Success(val data: List<Book>) : AppState()
    data class Error(val message: String) : AppState()
}