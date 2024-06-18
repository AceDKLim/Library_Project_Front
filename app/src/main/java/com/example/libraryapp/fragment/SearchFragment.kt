package com.example.libraryapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.libraryapp.R
import com.example.libraryapp.adapter.SearchAdapter
import com.example.libraryapp.databinding.FragmentSearchBinding
import com.example.libraryapp.fragment.book.BookDetailFragment
import com.example.libraryapp.retrofit.RetrofitClientInstance
import com.example.libraryapp.retrofit.book.Book
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchFragment : Fragment() {
    
    private var searchResult: List<Book> = listOf()   // 리사이클러 뷰 아이템
    private var keyword = ""        // 검색 키워드
    
    private var _binding: FragmentSearchBinding? = null
    private val searchAdapter = SearchAdapter(searchResult)    // 리사이클러 뷰 어댑터
    private val bookApi = RetrofitClientInstance.bookApi
    
    private val binding get() = _binding!!
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // 리사이클러 뷰
        binding.rvList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvList.adapter = searchAdapter
        
        // 리스트 아이템 클릭 시 해당 위치로 이동
        searchAdapter.setItemClickListener(object : SearchAdapter.OnItemClickListener {
            override fun onClick(v: View, position: Int) {
                //책 상세정보 페이지로 이동
                childFragmentManager.beginTransaction()
                    .replace(R.id.main_container, BookDetailFragment()).commit()
            }
        })
        
        // 검색 버튼
        binding.btnSearch.setOnClickListener {
            keyword = binding.etSearchField.text.toString()
            searchKeyword(keyword)
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    
    // 키워드 검색 함수
    private fun searchKeyword(keyword: String) {
        
        bookApi.searchBook(keyword).enqueue(object : Callback<List<Book>> {
            override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
                if (response.isSuccessful) {
                    searchResult = response.body() ?: listOf()
                    searchAdapter.updateBooks(searchResult)
                }
            }
            
            override fun onFailure(call: Call<List<Book>>, t: Throwable) {
                // 오류 처리
            }
        })
        
    }
}

//검색 결과 처리 함수
//    private fun addItemsAndMarkers(searchResult: List<Book>) {
//        if (!searchResult?.documents.isNullOrEmpty()) {
//            listItems.clear()
//            binding.mapView.removeAllPOIItems()
//            for (document in searchResult!!.documents) {
//                val item = ListLayout(document.place_name,
//                    document.road_address_name,
//                    document.address_name,
//                    document.x.toDouble(),
//                    document.y.toDouble())
//                listItems.add(item)
//
//                val point = MapPOIItem()
//                point.apply {
//                    itemName = document.place_name
//                    mapPoint = MapPoint.mapPointWithGeoCoord(document.y.toDouble(), document.x.toDouble())
//                    markerType = MapPOIItem.MarkerType.BluePin
//                    selectedMarkerType = MapPOIItem.MarkerType.RedPin
//                }
//                binding.mapView.addPOIItem(point)
//            }
//            listAdapter.notifyDataSetChanged()
//
//            binding.btnNextPage.isEnabled = !searchResult.meta.is_end
//            binding.btnPrevPage.isEnabled = pageNumber != 1
//        } else {
//            Toast.makeText(requireContext(), "검색 결과가 없습니다", Toast.LENGTH_SHORT).show()
//        }
//    }
//}
