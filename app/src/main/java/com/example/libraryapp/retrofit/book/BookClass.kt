package com.example.libraryapp.retrofit.book

import com.google.gson.annotations.SerializedName

data class Book(
    @SerializedName("isbnNo") var isbnNo: String,
    @SerializedName("title") var title: String,
    @SerializedName("author") var author: String,
    @SerializedName("publish") var publish: String,
    @SerializedName("pubyear") var pubyear: String,
    @SerializedName("num") var num: String,
    @SerializedName("location") var location: String,
    @SerializedName("imageSrc") var imageSrc: String,
    @SerializedName("detailSrc") var detailSrc: String,
    @SerializedName("tags") var tags: String
)

data class Books(val book: List<Book>)

data class ModifyBook(
    @SerializedName("title") var title: String,
    @SerializedName("author") var author: String,
    @SerializedName("publish") var publish: String,
    @SerializedName("pubyear") var pubyear: String,
    @SerializedName("num") var num: String,
    @SerializedName("location") var location: String,
    @SerializedName("imageSrc") var imageSrc: String,
    @SerializedName("detailSrc") var detailSrc: String,
    @SerializedName("tags") var tags: String
)

data class Keyword(
    @SerializedName("tag1") var tag1: String,
    @SerializedName("tag2") var tag2: String
)

