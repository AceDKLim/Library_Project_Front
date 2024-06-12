package com.example.libraryapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.libraryapp.R
import com.example.libraryapp.retrofit.review.Review

class ReviewAdapter(private val context: Context, private val mList: ArrayList<Review>) : RecyclerView.Adapter<ReviewAdapter.CustomViewHolder>() {

    inner class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val reviewRate: TextView = view.findViewById(R.id.reviewRate)
        val reviewUserid: TextView = view.findViewById(R.id.reviewUserid)
        val reviewTitle: TextView = view.findViewById(R.id.reviewTitle)
        val reviewReview: TextView = view.findViewById(R.id.reviewReview)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.reviewlist, viewGroup, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(viewholder: CustomViewHolder, position: Int) {
        val reviewResponse = mList[position]

        viewholder.reviewRate.text = reviewResponse.score
        viewholder.reviewUserid.text = reviewResponse.isbnNo
        viewholder.reviewTitle.text = reviewResponse.title
        viewholder.reviewReview.text = reviewResponse.content
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}
