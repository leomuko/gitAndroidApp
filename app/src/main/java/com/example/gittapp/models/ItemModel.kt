package com.example.gittapp.models

import com.google.gson.annotations.SerializedName

data class ItemModel (
    @SerializedName("items")
    var items : List<AdapterModel>
)