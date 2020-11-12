package com.e.fetchdataapp

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.paging.DataSource
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Response
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityViewModel: MainActivityViewModel
    private lateinit var recView: RecyclerView
    private lateinit var progressBar: ProgressBar



    private var items: List<Item> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModelProviderFactory = ViewModelProviderFactory(this)

        mainActivityViewModel = ViewModelProvider(this, viewModelProviderFactory).get(MainActivityViewModel::class.java)

        recView = findViewById(R.id.recView)
        progressBar = findViewById(R.id.progressBar)
//        itemAdapter = ItemAdapter(items)
        recView.layoutManager = LinearLayoutManager(this)
//        recView.adapter = itemAdapter

        mainActivityViewModel.getPagedListData().observe(this, object : Observer<PagedList<Item>>{
            override fun onChanged(t: PagedList<Item>?) {
                val pItemsAdapter = PItemAdapter(items)
                pItemsAdapter.submitList(items as PagedList<Item>?)
                recView.adapter = pItemsAdapter
            }

        })






    }


}