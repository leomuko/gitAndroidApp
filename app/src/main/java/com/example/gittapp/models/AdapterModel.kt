package com.example.gittapp.models

import android.os.Parcelable
import com.example.gittapp.R
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.recycler_screen.view.*

@Parcelize
data class AdapterModel (
    @SerializedName("avatar_url")
    val userImage: String = "",
    var followers: String = "100",
    var following: String = "100",
    var repos: String = "200",
    @SerializedName("login")
    val userName:String) : Parcelable