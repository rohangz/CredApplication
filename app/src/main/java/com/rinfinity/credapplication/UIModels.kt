package com.rinfinity.credapplication

data class ListItemModel(
    var itemTitle: String,
    var itemDescription: String,
    var isItemExpanded: Boolean
)


data class UIUpdateModel(
    var item: ListItemModel,
    var index: Int
)
