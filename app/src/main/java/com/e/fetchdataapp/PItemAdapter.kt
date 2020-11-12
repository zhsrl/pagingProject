package com.e.fetchdataapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class PItemAdapter(val itemlist: List<Item>?): PagedListAdapter<Item, PItemAdapter.ViewHolder>(DiffCallback()) {

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
        holder.bind(itemlist!![position])
    }

    class DiffCallback(): DiffUtil.ItemCallback<Item>(){
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }

    }


}
//class PhotosAdapter : PagedListAdapter<Photos?, PhotosAdapter.PhotoViewHolder?>(Photos.CALLBACK) {
//    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): PhotoViewHolder {
//        val layoutInflater = LayoutInflater.from(viewGroup.context)
//        val view: View = layoutInflater.inflate(R.layout.list_photoes, viewGroup, false)
//        return PhotoViewHolder(view)
//    }
//
//    override fun onBindViewHolder(photoViewHolder: PhotoViewHolder, i: Int) {
//        Glide.with(photoViewHolder.itemView.context).load(getItem(i).getUrl()).into(photoViewHolder.ivPhoto)
//    }
//
//    inner class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        var ivPhoto: ImageView
//
//        init {
//            ivPhoto = itemView.findViewById(id.imageView)
//        }
//    }
//}

