package com.example.libraryapp.fragment


import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.libraryapp.R
import com.example.libraryapp.adapter.ReviewAdapter
import com.example.libraryapp.retrofit.RetrofitClientInstance
import com.example.libraryapp.retrofit.review.Review

class ReviewsFragment : Fragment() {

    // 리뷰 작성에 필요한 정보를 저장하는 전역 변수들
    private lateinit var title: String
    private lateinit var content: String
    private lateinit var isbnNo: String
    private lateinit var score: String
    
    private val api = RetrofitClientInstance.reviewApi

    private lateinit var mTextViewResult: TextView
    private lateinit var mArrayList: ArrayList<Review>
    private lateinit var mAdapter: ReviewAdapter
    private lateinit var mRecyclerView: RecyclerView
    private var mJsonString: String? = null

    private var name: String? = null
    private var loginID: String? = null
    private var loginSort: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_rreview, container, false)

        arguments?.let {
            name = it.getString("name")
            loginID = it.getString("loginID")
            loginSort = it.getString("loginSort")
        }

        mTextViewResult = view.findViewById(R.id.textView_main_result)
        mRecyclerView = view.findViewById(R.id.listView_main_list)

        mRecyclerView.addItemDecoration(DividerItemDecoration(mRecyclerView.context, 1))
        mRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        mTextViewResult.movementMethod = ScrollingMovementMethod()

        mArrayList = ArrayList()
        mAdapter = ReviewAdapter(requireContext(), mArrayList)
        mRecyclerView.adapter = mAdapter
        
        val btn1: Button = view.findViewById(R.id.reviewwirteButton)
        btn1.setOnClickListener {
            // 리뷰 작성 페이지로 이동
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_container, ReviewsFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        return view
    }

}
