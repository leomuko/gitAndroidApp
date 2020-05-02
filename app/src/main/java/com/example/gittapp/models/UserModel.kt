package com.example.gittapp.models

import com.google.gson.annotations.SerializedName

data class UserModel(
    @SerializedName("login")
    val userName : String,
    @SerializedName("followers")
    var followers: Int,
    @SerializedName("following")
    var following: Int,
    @SerializedName("public_repos")
    var repos: Int
)