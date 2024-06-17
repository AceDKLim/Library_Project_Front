package com.example.libraryapp.fragment.book

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.libraryapp.R
import com.example.libraryapp.retrofit.book.Book

class BookInformationFragment : Fragment() {
    private lateinit var isbnTextView: TextView
    private lateinit var titleTextView: TextView
    private lateinit var nameTextView: TextView
    private lateinit var publishTextView: TextView
    private lateinit var yearTextView: TextView
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bookinformation, container, false)
        
        // UI 요소 초기화
        isbnTextView = view.findViewById(R.id.tv_list_ISBN)
        titleTextView = view.findViewById(R.id.tv_list_title)
        nameTextView = view.findViewById(R.id.tv_list_name)
        publishTextView = view.findViewById(R.id.tv_list_publish)
        yearTextView = view.findViewById(R.id.tv_list_year)
        
        return view
    }
    
    fun setBook(book: Book) {
        isbnTextView.text = book.isbnNo
        titleTextView.text = book.title
        nameTextView.text = book.author
        publishTextView.text = book.publish
        yearTextView.text = book.pubyear
    }
}
