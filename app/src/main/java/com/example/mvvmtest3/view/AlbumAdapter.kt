package com.example.mvvmtest3.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmtest3.R
import com.example.mvvmtest3.databinding.RecyclerAlbumDataBinding
import com.example.mvvmtest3.model.AlbumResponseItem

class AlbumAdapter(private val albumResponseItem: List<AlbumResponseItem>) :
    RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

    override fun getItemCount() = albumResponseItem.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AlbumViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.recycler_album_data,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
            holder.recyclerAlbumDataBinding.album=albumResponseItem[position]
    }


    inner class AlbumViewHolder(val recyclerAlbumDataBinding: RecyclerAlbumDataBinding) :
        RecyclerView.ViewHolder(recyclerAlbumDataBinding.root)
}