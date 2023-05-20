package com.erkindilekci.bookapp.data.remote.dto

import com.erkindilekci.bookapp.domain.model.Book

data class BookDto(
    val authors: List<String>,
    val categories: List<String>,
    val isbn: String,
    val longDescription: String,
    val pageCount: Int,
    val publishedDate: PublishedDate,
    val shortDescription: String,
    val status: String,
    val thumbnailUrl: String,
    val title: String
) {
    fun toBook(): Book = Book(
        authors ?: emptyList(),
        categories ?: emptyList(),
        isbn ?: "",
        longDescription ?: "", // veya "N/A" gibi bir varsayılan değer
        publishedDate?.toString() ?: "",
        shortDescription ?: "",
        thumbnailUrl ?: "",
        title ?: ""
    )
}