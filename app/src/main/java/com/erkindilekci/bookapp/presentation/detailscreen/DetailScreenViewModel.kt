package com.erkindilekci.bookapp.presentation.detailscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.erkindilekci.bookapp.domain.repository.BookRepository
import com.erkindilekci.bookapp.presentation.util.DetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel @Inject constructor(
    private val repo: BookRepository
) : ViewModel() {
    private val _appState = MutableStateFlow<DetailState>(DetailState.Loading)
    val appState: StateFlow<DetailState> = _appState.asStateFlow()

    fun getSelectedBook(isbnNo: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val selectedBook = repo.getBooks().map { it.toBook() }.filter { it.isbn == isbnNo}.firstOrNull()
                selectedBook?.let {
                    _appState.value = DetailState.Success(it)
                }
            } catch (e: IOException) {
                _appState.value = DetailState.Error(e.localizedMessage)
            } catch (e: Exception) {
                _appState.value = DetailState.Error(e.localizedMessage)
            }
        }
    }
}    