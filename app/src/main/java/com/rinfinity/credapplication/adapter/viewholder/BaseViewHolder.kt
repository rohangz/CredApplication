package com.rinfinity.credapplication.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.rinfinity.credapplication.ListItemModel

abstract class BaseViewHolder(root: View): RecyclerView.ViewHolder(root) {
    abstract fun bindData(position: Int, data: ListItemModel)
}