package com.example.libraryapp.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.libraryapp.fragment.book.BooksFragment
import com.example.libraryapp.MainActivity
import com.example.libraryapp.R
import com.example.libraryapp.SearchFragment
import com.example.libraryapp.databinding.ActivityHomeBinding
import com.example.libraryapp.retrofit.RetrofitClientInstance

class HomeActivity : AppCompatActivity() {
    private val binding: ActivityHomeBinding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }

    // UserApi 인스턴스 생성
    private val userApi = RetrofitClientInstance.userApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setBottomNavigationView()

        // 앱 초기 실행 시 홈화면으로 설정
        if (savedInstanceState == null) {
            binding.bottomNavigationView.selectedItemId = R.id.fragment_books
        }
    }

    private fun setBottomNavigationView() {
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.fragment_books -> {
                    supportFragmentManager.beginTransaction().replace(R.id.main_container, BooksFragment()).commit()
                    true
                }
                R.id.fragment_search -> {
                    supportFragmentManager.beginTransaction().replace(R.id.main_container, SearchFragment()).commit()
                    true
                }
                R.id.fragment_logout -> {
                    // 로그아웃 요청
                    logoutAndNavigateToMainActivity()
                    true
                }
                else -> false
            }
        }
    }

    private fun logoutAndNavigateToMainActivity() {
        userApi.logout()
        val intent = Intent(this@HomeActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
