package com.e.fetchdataapp

import android.content.Context
import android.widget.Toast
import androidx.paging.PageKeyedDataSource
import retrofit2.Call
import retrofit2.Response

class ListDataSource(val context: Context): PageKeyedDataSource<Long, Item>() {

    private lateinit var api: ApiService.Api

    override fun loadInitial(params: LoadInitialParams<Long>, callback: LoadInitialCallback<Long, Item>) {
        ApiService
                .fetchData()
                .getData(1)
                .enqueue(object : retrofit2.Callback<List<Item>> {
                    override fun onResponse(call: Call<List<Item>>?, response: Response<List<Item>>?) {
                        val list = response?.body()
                        callback.onResult(list!!, null, 2.toLong())
                    }

                    override fun onFailure(call: Call<List<Item>>?, t: Throwable?) {
                        Toast.makeText(context,"Error LoadInitial" + t.toString(), Toast.LENGTH_SHORT).show()
                    }
                })
    }

    override fun loadBefore(params: LoadParams<Long>, callback: LoadCallback<Long, Item>) {
        TODO("Not yet implemented")
    }

    override fun loadAfter(params: LoadParams<Long>, callback: LoadCallback<Long, Item>) {
        ApiService
                .fetchData()
                .getData(params.key)
                .enqueue(object : retrofit2.Callback<List<Item>>{
                    override fun onResponse(call: Call<List<Item>>?, response: Response<List<Item>>?) {
                        val list = response?.body()
                        callback.onResult(list!!,((params.key)+1))
                    }

                    override fun onFailure(call: Call<List<Item>>?, t: Throwable?) {
                        Toast.makeText(context,"Error Before" + t.toString(), Toast.LENGTH_SHORT).show()
                    }
                })
    }
}