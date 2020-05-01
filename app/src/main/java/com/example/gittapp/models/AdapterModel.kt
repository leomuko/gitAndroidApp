package com.example.gittapp.models

import com.example.gittapp.R
import com.google.gson.annotations.SerializedName
import kotlinx.android.synthetic.main.recycler_screen.view.*

data class RecyclerItem (
    @SerializedName("avatar_url")
    val imageResource1: String = "",
    var text1: String = "100",
    @SerializedName("login")
    val text2:String)