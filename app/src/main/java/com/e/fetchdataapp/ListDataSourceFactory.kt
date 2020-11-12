package com.e.fetchdataapp

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource


class ListDataSourceFactory(val context: Context) : DataSource.Factory<Long, Item>() {


    var listDataSource: ListDataSource? = null
    var mutableLiveData: MutableLiveData<ListDataSource?>



    override fun create(): DataSource<Long, Item>? {
        listDataSource = ListDataSource(context)
        mutableLiveData.postValue(listDataSource)
        return listDataSource
    }

    @JvmName("getMutableLiveData1")
    fun getMutableLiveData(): MutableLiveData<ListDataSource?> {
        return mutableLiveData
    }

    init {
        mutableLiveData = MutableLiveData<ListDataSource?>()
    }
}
