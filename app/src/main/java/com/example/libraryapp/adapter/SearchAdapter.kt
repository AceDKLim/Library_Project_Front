package com.example.libraryapp.adapter
// 리사이클러 뷰 어댑터 클래스
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.libraryapp.R
import com.example.libraryapp.retrofit.book.Book

class SearchAdapter(private var searchResult: List<Book>): RecyclerView.Adapter<SearchAdapter.ViewHolder>() {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return searchResult.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = searchResult[position].title
        holder.name.text = searchResult[position].author
        holder.publish.text = searchResult[position].publish
        Glide.with(holder.itemView.context).load(searchResult[position].imageSrc).into(holder.bookImage)
        // 아이템 클릭 이벤트
        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
        }
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tv_list_title)
        val name: TextView = itemView.findViewById(R.id.tv_list_name)
        val publish: TextView = itemView.findViewById(R.id.tv_list_publish)
        val bookImage: ImageView = itemView.findViewById(R.id.img01)
    }

    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }

    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }

    private lateinit var itemClickListener : OnItemClickListener
    
    fun updateBooks(newBooks: List<Book>) {
        searchResult = newBooks
        notifyDataSetChanged()
    }
}