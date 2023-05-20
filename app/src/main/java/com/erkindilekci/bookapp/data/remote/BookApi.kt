package com.erkindilekci.bookapp.data.remote

import com.erkindilekci.bookapp.data.remote.dto.BookDto
import retrofit2.http.GET

interface BookApi {
    @GET("erkindil/Json/main/books.json")
    suspend fun getBooks(): List<BookDto>
}