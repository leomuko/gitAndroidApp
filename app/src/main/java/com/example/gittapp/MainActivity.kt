package com.example.gittapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val theList = ArrayList<RecyclerItem>()
       // val item = RecyclerItem(R.drawable.ic_photo, "100", "Leo Katwere")
        for (i in 0..10){
            var item = RecyclerItem(R.drawable.ic_photo, "100", "Leo Katwere")
            theList += item
        }


        recycler_view.adapter = RecyclerAdapter(theList)
        recycler_view.layoutManager = GridLayoutManager(this,2)
        recycler_view.setHasFixedSize(true)

    }

}
