package com.rinfinity.credapplication.repo

import com.rinfinity.credapplication.ListItemModel

object DataProvider {
    val uiList: ArrayList<ListItemModel> =
        ArrayList<ListItemModel>().apply {
            add(
                ListItemModel(
                    itemTitle = "Title of Item 1",
                    itemDescription = "This is supposed to be a lengthy description for the item placed at position 1",
                    isItemExpanded = true
                )
            )
        }
}