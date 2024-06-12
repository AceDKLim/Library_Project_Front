package com.example.libraryapp.fragment.book

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.libraryapp.adapter.AladinAdapter
import com.example.libraryapp.adapter.BookAdapter
import com.example.libraryapp.R
import com.example.libraryapp.databinding.FragmentBooksBinding
import com.example.libraryapp.retrofit.RetrofitClientInstance

class BooksFragment : Fragment() {

    private lateinit var binding: FragmentBooksBinding
    private lateinit var bookAdapter: BookAdapter
    private lateinit var aladinAdapter: AladinAdapter

    private val bookRepository = RetrofitClientInstance.bookApi
    val recommendedBooks = bookRepository.getRecommendBook()
    val popularBooks = bookRepository.getPopularBooks()

    private val aladinRepository= RetrofitClientInstance.aladinApi
    val newbooks=aladinRepository.newbook()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBooksBinding.inflate(inflater, container, false)
        setupRecyclerView()
        setupSpinner(binding.spinnerFilter)
        return binding.root
    }

    private fun setupRecyclerView() {
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        bookAdapter = BookAdapter(recommendedBooks)
        bookAdapter = BookAdapter(popularBooks)
        aladinAdapter= AladinAdapter(newbooks)
//        binding.recyclerView.adapter = bookAdapter
    }

    private fun setupSpinner(spinner: Spinner) {
        val options = listOf("AI 추천도서", "인기도서", "신간도서")
        val adapter = ArrayAdapter(requireContext(), R.layout.fragment_books, options)
        adapter.setDropDownViewResource(R.layout.fragment_books)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                when (position) {
                    0 -> bookAdapter.updateBooks(recommendedBooks) // AI 추천도서
                    1 -> bookAdapter.updateBooks(popularBooks) // 인기도서
                    2 -> aladinAdapter.updateBooks(newbooks) // 신간도서
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }
    }
}
