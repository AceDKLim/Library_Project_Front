package com.example.libraryapp.retrofit.review

import com.google.gson.annotations.SerializedName

data class Review(
    @SerializedName("title") var title: String,
    @SerializedName("content") var content: String,
    @SerializedName("isbnNo") var isbnNo: String,
    @SerializedName("score") var score: String
)
data class ReviewResponse(
    @SerializedName("id") var id: String,
    @SerializedName("title") var title: String,
    @SerializedName("content") var content: String,
    @SerializedName("isbnNo") var isbnNo: String,
    @SerializedName("studentnumber") var studentnumber: String,
    @SerializedName("score") var score: String
)
data class ReviewResponses(val reviewResponse: ReviewResponse)

data class ModiReview(
    @SerializedName("id") var id: String,
    @SerializedName("title") var title: String,
    @SerializedName("content") var content: String,
    @SerializedName("isbnNo") var isbnNo: String,
    @SerializedName("studentnumber") var studentnumber: String,
    @SerializedName("score") var score: String
)