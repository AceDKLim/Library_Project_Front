package com.example.libraryapp.fragment.book

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.libraryapp.R
import com.example.libraryapp.retrofit.book.Book

class BookInformationFragment : Fragment() {
    private var book = Book("", "", "", "", "", "", "", "", "", "")

    fun setBook(book: Book) {
        this.book = book
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bookinformation, container, false)
    }
}