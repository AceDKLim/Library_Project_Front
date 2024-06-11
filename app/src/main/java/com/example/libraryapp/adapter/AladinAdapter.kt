package com.example.libraryapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.libraryapp.retrofit.book.Aladin

data class AladinAdapter(private var aladins: List<Aladin>) : RecyclerView.Adapter<AladinAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bookImage: ImageButton = itemView.findViewById(R.id.book_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bookkk = aladins[position]

        // book_image 버튼에 대한 클릭 이벤트 처리
        holder.bookImage.setOnClickListener {
            val context = holder.itemView.context
            val fragment = BookinformationFragment() // BookInformationFragment로 전환
            val transaction = (context as AppCompatActivity).supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_container, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

    override fun getItemCount(): Int {
        return aladins.size
    }

    fun updateBooks(newBooks: List<Aladin>) {
        aladins = newBooks
        notifyDataSetChanged()
    }
}

