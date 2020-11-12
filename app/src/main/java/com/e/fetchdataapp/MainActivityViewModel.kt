package com.e.fetchdataapp

import android.app.Application
import android.content.Context
import android.graphics.pdf.PdfDocument
import android.provider.Contacts.Photos
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import java.util.concurrent.Executor
import java.util.concurrent.Executors


class MainActivityViewModel(application: Application): AndroidViewModel(application) {

    private var dataSourceFactory: ListDataSourceFactory
    private var dataSourceMutableLiveData: MutableLiveData<ListDataSource?>
    private var executor: Executor
    private var pagedListLiveData: LiveData<PagedList<Item>>

    init {
        dataSourceFactory = ListDataSourceFactory(application)
        dataSourceMutableLiveData = dataSourceFactory.getMutableLiveData()

        val config = PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(10)
                .setPageSize(20)
                .setPrefetchDistance(4)
                .build()

        executor = Executors.newFixedThreadPool(5)
        pagedListLiveData = LivePagedListBuilder<Long, Item>(dataSourceFactory,config)
                .setFetchExecutor(executor)
                .build()
    }

    fun getPagedListData(): LiveData<PagedList<Item>>{
        return pagedListLiveData
    }


}

//class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
//    var photoRepository: PhotoRepository? = null
//    var photoDataSourceFactory: PhotoDataSourceFactory
//    var dataSourceMutableLiveData: MutableLiveData<PhotoDataSource>
//    var executor: Executor
//    var pagedListLiveData: LiveData<PagedList<Photos>>
//
//    init {
//        photoDataSourceFactory = PhotoDataSourceFactory()
//        dataSourceMutableLiveData = photoDataSourceFactory.getMutableLiveData()
//        val config = PagedList.Config.Builder()
//                .setEnablePlaceholders(true)
//                .setInitialLoadSizeHint(10)
//                .setPageSize(20)
//                .setPrefetchDistance(4)
//                .build()
//        executor = Executors.newFixedThreadPool(5)
//        pagedListLiveData = LivePagedListBuilder<Long, Photos>(photoDataSourceFactory, config)
//                .setFetchExecutor(executor)
//                .build()
//    }
//}