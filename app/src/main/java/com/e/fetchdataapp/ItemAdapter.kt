package com.e.fetchdataapp


import android.annotation.SuppressLint
import android.provider.Contacts.Photos
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView


class ItemAdapter(var itemList: List<Item>?,): RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    inner class ViewHolder(val view: View): RecyclerView.ViewHolder(view){
        lateinit var itemID: TextView
        lateinit var userID: TextView
        lateinit var title: TextView

        @SuppressLint("SetTextI18n")
        fun bind(item: Item?){
            init()

            itemID.text = item?.id
            userID.text = """User ID: ${item?.userId}"""
            title.text = item?.title
        }

        fun init(){
            itemID = view.findViewById(R.id.idTV)
            userID = view.findViewById(R.id.userIdTV)
            title = view.findViewById(R.id.titleTV)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_model, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemList!![position])
    }

    override fun getItemCount(): Int {
        return itemList!!.size
    }

}


