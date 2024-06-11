package com.example.libraryapp.retrofit

import com.example.libraryapp.retrofit.book.AladinApi
import com.example.libraryapp.retrofit.book.BookApi
import com.example.libraryapp.retrofit.review.ReviewAPI
import com.example.libraryapp.retrofit.user.UserApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientInstance {
    private const val BASE_URL = "http://52.78.146.166:8080/api/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val userApi: UserApi by lazy {
        retrofit.create(UserApi::class.java)
    }

    var bookApi: BookApi = retrofit.create(BookApi::class.java)
//    val bookApi: BookApi by lazy {
//        retrofit.create(BookApi::class.java)
//    }

    val reviewApi: ReviewAPI by lazy {
        retrofit.create(ReviewAPI::class.java)
    }

    var aladinApi: AladinApi = retrofit.create(AladinApi::class.java)
//    val aladinApi: aladinApi by lazy {
//        retrofit.create(aladinApi::class.java)
//    }
}
