package com.example.gittapp.services

import com.example.gittapp.models.UserModel
import com.example.gittapp.models.ItemModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("search/users?q=type:User+location:Kampala+language:Python")
    fun getUserList(): Call<ItemModel>

    @GET("users/{userName}")
    fun getFollowers(@Path("userName") userName : String): Call<UserModel>
}