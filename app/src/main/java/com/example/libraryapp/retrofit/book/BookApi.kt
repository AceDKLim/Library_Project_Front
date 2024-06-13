package com.example.libraryapp.retrofit.book


import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface BookApi {
    @GET("books")
    fun getBooks(): List<Book>

    @GET("books/{isbnNo}")
    fun getBook(@Path(value = "isbnNo") isbnNo: String): Call<Book>

    @GET("search/{key_word}")
    fun searchBook(@Path(value = "key_word") keyWord: String): List<Book>

    @GET("popularbooks")
    fun getPopularBooks(): Call<List<Book>>

    @GET("recommend")
    fun getRecommendBook(): Call<List<Book>>

    @POST("books")
    suspend fun postBooks(@Body book: Book): Book

    @POST("keywords")
    suspend fun postKeywords(@Body keywords: Keyword): KeywordResponse

    @DELETE("books/{isbnNo}")
    suspend fun deleteBooks(@Path(value = "isbnNo") isbnNo: String): Void

    @PUT("books/{isbnNo}")
    suspend fun modifyBooks(@Path(value = "isbnNo") isbnNo: String, @Body book: Book): Book
}