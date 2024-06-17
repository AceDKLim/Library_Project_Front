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

class LocationFragment : Fragment() {
    private lateinit var num: TextView
    private lateinit var location: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_location, container, false)
        
        num = view.findViewById(R.id.tv_list_num1)
        location = view.findViewById(R.id.tv_list_location1)
        
        return view
    }
    
    fun setBook(book: Book) {
//        num.text = book.num
        location.text = book.location
    }
}