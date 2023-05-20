package com.erkindilekci.bookapp.domain.repository

import com.erkindilekci.bookapp.data.remote.dto.BookDto
import com.erkindilekci.bookapp.domain.model.Book

interface BookRepository {
    suspend fun getBooks(): List<BookDto>
}