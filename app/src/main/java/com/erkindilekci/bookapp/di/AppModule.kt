package com.erkindilekci.bookapp.di

import com.erkindilekci.bookapp.data.remote.BookApi
import com.erkindilekci.bookapp.data.repository.BookRepositoryImpl
import com.erkindilekci.bookapp.domain.repository.BookRepository
import com.erkindilekci.bookapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideBookApi(): BookApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BookApi::class.java)
    }

    @Provides
    @Singleton
    fun provideBookRepository(api: BookApi): BookRepository = BookRepositoryImpl(api)
}