package com.erkindilekci.bookapp.domain.model

data class Book(
    val authors: List<String>,
    val categories: List<String>,
    val isbn: String,
    val longDescription: String,
    val publishedDate: String,
    val shortDescription: String,
    val thumbnailUrl: String,
    val title: String
)
