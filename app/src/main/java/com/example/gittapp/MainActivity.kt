package com.example.gittapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerListt = generateDummyList(20)

        recycler_view.adapter = RecyclerAdapter(recyclerListt)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)

    }
    private fun generateDummyList(size: Int) : List<RecyclerItem>{
        val list = ArrayList<RecyclerItem>()

        for (i in 0 until size){
            val drawable = when( i % 2) {
                0 -> R.drawable.ic_photo
                else -> R.drawable.ic_photo
            }

            val item = RecyclerItem(drawable,drawable, "Leo","katwere")
            list += item
        }
        return list
    }
}
