//package com.example.libraryapp.retrofit.book
//
//import retrofit2.Response
//
//class BookRepository(private val bookApi: bookApi) {
//
//    fun popularBooks():List<Book> {
//        val popularBooks = bookApi.getPopularBooks()
//        return try {
//            val response: Response<Books> = popularBooks.execute()
//            if (response.isSuccessful) {
//                response.body()?.books ?: emptyList()
//            } else {
//                println("Response not successful: ${response.errorBody()}")
//                emptyList()
//            }
//        } catch (e: Exception) {
//            println("API call failed: ${e.message}")
//            emptyList()
//        }
//    }
//
//    fun recommendBooks():List<Book> {
//        val recommendBooks = bookApi.getRecommendBook()
//        return try {
//            val response : Response<Books> = recommendBooks.execute()
//            if (response.isSuccessful) {
//                response.body()?.books ?: emptyList()
//            } else {
//                println("Response not successful: ${response.errorBody()}")
//                emptyList()
//            }
//        } catch (e: Exception) {
//            println("API call failed: ${e.message}")
//            emptyList()
//        }
//    }
//}