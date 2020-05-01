package com.example.gittapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.gittapp.models.UserModel
import com.example.gittapp.models.ItemModel
import com.example.gittapp.models.AdapterModel
import com.example.gittapp.services.ApiClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), onItemClickListener {

    var theList = ArrayList<AdapterModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.adapter = RecyclerAdapter(theList, this)
        recycler_view.layoutManager = GridLayoutManager(this, 2)
        recycler_view.setHasFixedSize(true)
        getUsers()


    }

    override fun onItemClick(item: AdapterModel, position: Int) {

        val intent = Intent(this, DetailActivity::class.java)
        startActivity(intent)
    }

    private fun getUsers() {
        val call: Call<ItemModel> = ApiClient.getClient.getUserList()
        call.enqueue(object : Callback<ItemModel> {
            override fun onFailure(call: Call<ItemModel>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Data not Fetched", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<ItemModel>, response: Response<ItemModel>) {

                val body = response?.body()
                theList.addAll(body!!.items)

                for (i in 0 until (theList.size - 1)) {
                    getFollowers(theList[i].userName)

                }
                recycler_view.adapter?.notifyDataSetChanged()
            }

        })
    }

    private fun getFollowers(name: String) {
        val call: Call<UserModel> = ApiClient.getClient.getFollowers(name)
        call.enqueue(object : Callback<UserModel> {
            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Followers not fetched", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                val body = response.body()!!
                for (i in 0 until (theList.size - 1)) {
                    if (theList[i].userName == body.userName) {
                        theList[i].followers = body.followers.toString()
                    }
                }


            }

        })


    }

}
