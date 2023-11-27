package com.helium4.mindtek.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.helium4.mindtek.viewModel.ItemWithImage
import com.helium4.mindtek.R

class ItemAdapter :
    ListAdapter<ItemWithImage, ItemAdapter.ItemViewHolder>(ItemSeparateCallback()) {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.imageView.setImageResource(currentItem.imageResource)
        holder.textView.text = currentItem.text
    }
}

class ItemSeparateCallback : DiffUtil.ItemCallback<ItemWithImage>() {
    override fun areItemsTheSame(oldItem: ItemWithImage, newItem: ItemWithImage): Boolean {
        return oldItem.imageResource == newItem.imageResource
    }

    override fun areContentsTheSame(oldItem: ItemWithImage, newItem: ItemWithImage): Boolean {
        return oldItem == newItem
    }
}
