package com.erkindilekci.bookapp.presentation.listscreen

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.erkindilekci.bookapp.data.remote.dto.BookDto
import com.erkindilekci.bookapp.domain.model.Book
import com.erkindilekci.bookapp.domain.repository.BookRepository
import com.erkindilekci.bookapp.presentation.util.AppState
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class ListScreenViewModel @Inject constructor(
    private val repo: BookRepository
) : ViewModel() {
    private val _appState = MutableStateFlow<AppState>(AppState.Loading)
    val appState: StateFlow<AppState> = _appState.asStateFlow()

    var searchText by mutableStateOf("")
        private set

    init {
        getAllBooks()
    }

    fun getAllBooks() {
        viewModelScope.launch(IO) {
            try {
                val bookList = repo.getBooks().map { it.toBook() }
                _appState.value = AppState.Success(bookList)
            } catch (e: IOException) {
                _appState.value = AppState.Error("No network available!")
            } catch (e: HttpException) {
                _appState.value = AppState.Error("No network available!")
            } catch (e: Exception) {
                _appState.value = AppState.Error(e.localizedMessage)
            }
        }
    }

    fun updateSearchText(newString: String){
        searchText = newString
    }
}