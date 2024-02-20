package com.ymd.challengetribal.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ymd.challengetribal.R
import com.ymd.challengetribal.listener.CategoryListener

class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val titleCategory: TextView = itemView.findViewById(R.id.title_category)

    fun bind(category: String, listener: CategoryListener) {

        titleCategory.text = category

        titleCategory.setOnClickListener {
            listener.onSelectCategory(category)
        }

    }

}