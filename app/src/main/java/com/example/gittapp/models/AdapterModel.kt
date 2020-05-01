package com.example.gittapp.models

import com.example.gittapp.R
import com.google.gson.annotations.SerializedName
import kotlinx.android.synthetic.main.recycler_screen.view.*

data class AdapterModel (
    @SerializedName("avatar_url")
    val userImage: String = "",
    var followers: String = "100",
    @SerializedName("login")
    val userName:String)