package com.example.libraryapp.retrofit.book
import retrofit2.http.GET

interface AladinApi {
    @GET("bestseller")
    fun bestseller(): Aladins

    @GET("newbook")
    fun newbook(): Aladins
}
