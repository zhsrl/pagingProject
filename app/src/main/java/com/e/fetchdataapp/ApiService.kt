package com.e.fetchdataapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object ApiService {

    const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    fun fetchData(): Api{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(Api::class.java)
    }

    interface Api{

        @GET("posts")
        fun getData(@Query("userId") userId: Long): retrofit2.Call<List<Item>>
    }
}