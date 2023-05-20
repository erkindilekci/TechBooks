package com.erkindilekci.bookapp.presentation.util

import com.erkindilekci.bookapp.domain.model.Book

sealed class DetailState {
    object Empty : DetailState()
    object Loading : DetailState()
    data class Success(val data: Book) : DetailState()
    data class Error(val message: String) : DetailState()
}