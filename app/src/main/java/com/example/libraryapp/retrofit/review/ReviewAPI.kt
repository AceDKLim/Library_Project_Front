package com.example.libraryapp.retrofit.review

import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ReviewAPI {
    @GET("reviews")
    suspend fun getMyReviews(): ReviewResponses

    @GET("reviews/{isbnNo}")
    suspend fun getBookReviews(@Path(value = "isbnNo") isbnNo : String): ReviewResponses

    @POST("reviews")
    suspend fun postReviews(@Body review: Review): ReviewResponse

    @DELETE("reviews/{isbnNo}")
    suspend fun deleteReview(@Path(value = "isbnNo") isbnNo : String): Void

    @PUT("reviews/{id}")
    suspend fun modifyReviews(@Path(value = "id") id : Int, @Body modiReview: ModiReview): ReviewResponse
}
