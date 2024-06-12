package com.example.libraryapp.retrofit.book
import retrofit2.http.GET

interface AladinApi {
    @GET("bestseller")
    fun bestseller(): List<Aladin>

    @GET("newbook")
    fun newbook(): List<Aladin>
}
