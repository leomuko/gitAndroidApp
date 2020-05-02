package com.example.gittapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gittapp.models.AdapterModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var myList: AdapterModel = intent.getParcelableExtra("hellp")
        followers.text = myList.followers
        Picasso.get().load(myList.userImage).into(imageView)
        following.text = myList.following
        repos.text = myList.repos

    }
}
