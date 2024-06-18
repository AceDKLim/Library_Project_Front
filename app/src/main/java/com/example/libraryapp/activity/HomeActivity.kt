package com.example.libraryapp.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.libraryapp.fragment.book.ShowBooksFragment
import com.example.libraryapp.MainActivity
import com.example.libraryapp.R
import com.example.libraryapp.fragment.SearchFragment
import com.example.libraryapp.databinding.ActivityHomeBinding
import com.example.libraryapp.retrofit.RetrofitClientInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
                    supportFragmentManager.beginTransaction().replace(R.id.main_container, ShowBooksFragment()).commit()
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
        userApi.logout().enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    val intent = Intent(this@HomeActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // 로그아웃 요청이 실패한 경우 처리
                    Toast.makeText(this@HomeActivity, "Logout failed. Please try again.", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                // 네트워크 오류 등 처리
                Toast.makeText(this@HomeActivity, "Network error. Please try again.", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
