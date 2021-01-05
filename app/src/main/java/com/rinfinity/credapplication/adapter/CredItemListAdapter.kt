package com.rinfinity.credapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rinfinity.credapplication.ListItemModel
import com.rinfinity.credapplication.adapter.viewholder.BaseViewHolder
import com.rinfinity.credapplication.databinding.AppCredItemBinding

class CredItemListAdapter(private val mList: ArrayList<ListItemModel>) :
    RecyclerView.Adapter<BaseViewHolder>() {

    private val mMaxItems: Int = 4
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val binding = AppCredItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CredItemViewHolder(binding)
    }

    override fun getItemCount(): Int = mList.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) =
        holder.bindData(position, mList[position])

    fun onItemExpand(position: Int) {
        if (position >= 0 && position < mList.size) {
            mList[position].isItemExpanded = true
            notifyItemChanged(position)
        }
    }

    fun onItemCompress(position: Int) {
        if (position >= 0 && position < mList.size) {
            mList[position].isItemExpanded = false
            notifyItemChanged(position)
        }
    }

    fun addItemToList() {
        if (mList.size < mMaxItems) {
            if (mList.size > 0) {
                mList[mList.size - 1].isItemExpanded = false
                notifyItemChanged(mList.size - 1)
            }
            mList.add(
                ListItemModel(
                    itemTitle = "Title of Item ${mList.size + 1}",
                    itemDescription = "This is supposed to be a lengthy description for the item placed at position ${mList.size + 1}",
                    isItemExpanded = true
                )
            )
            notifyItemInserted(mList.size - 1)
        }
    }


    fun removeItemFromList() {
        if (mList.size > 1) {
            mList.removeAt(mList.size - 1)
            notifyItemRemoved(mList.size)
            mList[mList.size - 1].isItemExpanded = true
            notifyItemChanged(mList.size - 1)
        }
    }

    val isPositionLast: Boolean
        get() =  mList.size == mMaxItems


    val isPositionFirst: Boolean
        get() = mList.size == 1

    inner class CredItemViewHolder(private val mBinding: AppCredItemBinding) :
        BaseViewHolder(mBinding.root) {
        override fun bindData(position: Int, data: ListItemModel) {
            mBinding.mModel = data
        }
    }
}