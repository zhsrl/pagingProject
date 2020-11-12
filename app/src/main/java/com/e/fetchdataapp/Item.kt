package com.e.fetchdataapp

data class Item(
    var userId: Int = 0,
    var id: String = "",
    var title: String = "",
    var body: String = "",
    var listItem: List<Item> = emptyList()
){
    fun getData(pos: Int, size: Int): List<Item>{

        return listItem
    }
}