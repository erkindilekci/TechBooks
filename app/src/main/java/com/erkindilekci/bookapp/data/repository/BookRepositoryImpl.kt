package com.erkindilekci.bookapp.data.repository

import com.erkindilekci.bookapp.data.remote.BookApi
import com.erkindilekci.bookapp.data.remote.dto.BookDto
import com.erkindilekci.bookapp.domain.model.Book
import com.erkindilekci.bookapp.domain.repository.BookRepository
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
    private val api: BookApi
) : BookRepository {

    override suspend fun getBooks(): List<BookDto> {
        return api.getBooks()
    }
}