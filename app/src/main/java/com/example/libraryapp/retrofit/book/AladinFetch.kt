//package com.example.libraryapp.retrofit.book
//
//import retrofit2.Response
//
//class AladinRepository(private val aladinApi: AladinApi) {
//    fun fetchAladin():List<Aladin> {
//        val call = aladinApi.newbook()
//        return try {
//            val response: Response<Aladins> = call.execute()
//            if (response.isSuccessful) {
//                response.body()?.aladins ?: emptyList()
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
