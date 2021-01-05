package com.rinfinity.credapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.rinfinity.credapplication.ListItemModel
import com.rinfinity.credapplication.R
import com.rinfinity.credapplication.adapter.CredItemListAdapter
import com.rinfinity.credapplication.databinding.ActivityMainBinding
import com.rinfinity.credapplication.repo.DataProvider

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mAdapter: CredItemListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUI()
        initList(DataProvider.uiList)
        setOnClickListeners()
    }

    private fun initUI() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    private fun initList(list: ArrayList<ListItemModel>) {
        mAdapter = CredItemListAdapter(list)
        mBinding.appList.adapter = mAdapter
        mBinding.appList.layoutManager = object : LinearLayoutManager(this) {
            override fun canScrollVertically(): Boolean = false
        }
    }

    private fun setOnClickListeners() {
        mBinding.appCta.setOnClickListener {
            mAdapter.addItemToList()
            setStateOfCta()
        }
    }

    private fun setStateOfCta() {
        mBinding.appCta.isClickable = !mAdapter.isPositionLast
        if (mBinding.appCta.isClickable) {
            mBinding.appCta.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_500))
        } else {
            mBinding.appCta.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_700))
        }
    }

    override fun onBackPressed() {
        setStateOfCta()
        if (mAdapter.isPositionFirst) finish() else mAdapter.removeItemFromList()

    }


}