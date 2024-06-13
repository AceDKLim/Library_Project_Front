package com.example.libraryapp.fragment.book

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.libraryapp.R
import com.example.libraryapp.fragment.ReviewsFragment
import com.example.libraryapp.retrofit.RetrofitClientInstance
import com.example.libraryapp.retrofit.book.Book
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookDetaleFragment : Fragment() {
    private var isbnNo: String = ""
    private val bookApi = RetrofitClientInstance.bookApi
    private var book = Book("", "", "", "", "", "", "", "", "", "")

    companion object {
        const val ISBN_NO = "isbn_no"
        fun newInstance(isbnNo: String): BookDetaleFragment {
            val fragment = BookDetaleFragment()
            val args = Bundle()
            args.putString(ISBN_NO, isbnNo)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            isbnNo = it.getString(ISBN_NO, "")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.page_layout, container, false)

        loadBookDetails()

        val imageView = view.findViewById<ImageView>(R.id.img)
        val imageurl = book.imageSrc
        Glide.with(this).load(imageurl).into(imageView)

        // ViewPager2에 어댑터 설정
        val adapter = PagerAdapter(this)
        adapter.addFragment(BookInformationFragment(), "책 정보")
        adapter.addFragment(LocationFragment(), "위치")
        adapter.addFragment(ReviewsFragment(), "리뷰")

        // ViewPage 참조
        val viewPager = view.findViewById<ViewPager2>(R.id.book_viewPager)
        viewPager.adapter = adapter

        // TabLayout과ViewPager2 연결
        val tabLayout = view.findViewById<TabLayout>(R.id.myPagetabLayout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = adapter.getPageTitle(position)
        }.attach()

        return view
    }

    private fun loadBookDetails() {
        bookApi.getBook(isbnNo).enqueue(object : Callback<Book> {
            override fun onResponse(call: Call<Book>, response: Response<Book>) {
                if (response.isSuccessful) {
                    book = response.body()!!
                    updateUI()
                    (childFragmentManager.findFragmentByTag("책 정보") as? BookInformationFragment)?.setBook(
                        book
                    )
                }
            }

            override fun onFailure(call: Call<Book>, t: Throwable) {
            }
        })
    }

    private fun updateUI() {
        view?.let {
            val imageView = it.findViewById<ImageView>(R.id.img)
            Glide.with(this).load(book.imageSrc).into(imageView)
        }
    }


    class PagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
        private val fragmentList = ArrayList<Fragment>()
        private val fragmentTitleList = ArrayList<String>()

        override fun getItemCount(): Int = fragmentList.size

        override fun createFragment(position: Int): Fragment = fragmentList[position]

        fun addFragment(fragment: Fragment, title: String) {
            fragmentList.add(fragment)
            fragmentTitleList.add(title)
        }

        fun getPageTitle(position: Int): CharSequence = fragmentTitleList[position]
    }

}
