package com.example.libraryapp.retrofit.book

import android.os.Parcel
import android.os.Parcelable
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
//): Parcelable {
//    constructor(parcel: Parcel) : this(
//        parcel.readString().toString(),
//        parcel.readString().toString(),
//        parcel.readString().toString(),
//        parcel.readString().toString(),
//        parcel.readString().toString(),
//        parcel.readString().toString(),
//        parcel.readString().toString(),
//        parcel.readString().toString(),
//        parcel.readString().toString(),
//        parcel.readString().toString()
//    )
//    override fun writeToParcel(parcel: Parcel, flags: Int) {
//        parcel.writeString(isbnNo)
//        parcel.writeString(title)
//        parcel.writeString(author)
//        parcel.writeString(publish)
//        parcel.writeString(pubyear)
//        parcel.writeString(num)
//        parcel.writeString(location)
//        parcel.writeString(imageSrc)
//        parcel.writeString(detailSrc)
//        parcel.writeString(tags)
//    }
//
//    override fun describeContents(): Int {
//        return 0
//    }
//
//    companion object CREATOR : Parcelable.Creator<Book> {
//        override fun createFromParcel(parcel: Parcel): Book {
//            return Book(parcel)
//        }
//
//        override fun newArray(size: Int): Array<Book?> {
//            return arrayOfNulls(size)
//        }
//    }
//}

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

data class KeywordResponse(
    @SerializedName("studentID") var studentID: String,
    @SerializedName("tags") var tags: String
)