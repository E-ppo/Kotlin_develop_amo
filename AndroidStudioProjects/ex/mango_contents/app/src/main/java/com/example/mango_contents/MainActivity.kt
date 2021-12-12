package com.example.mango_contents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val items= mutableListOf<ContentsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/RHt4Mtrl4zHp",
                "https://mp-seoul-image-production-s3.mangoplate.com/787041_1638595367931846.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "듁스커피"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/zVvOCUyTUZDp",
                "https://mp-seoul-image-production-s3.mangoplate.com/722502_1633917525002988.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "오흐뒤구떼"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/d6QJNyRAeUhU",
                "https://mp-seoul-image-production-s3.mangoplate.com/191512_1501744237053225.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "쥬마뺄"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/yGY6XQTTDLtY",
                "https://mp-seoul-image-production-s3.mangoplate.com/329767/24897_1637832854727_62923?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "시루케이크"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/RHt4Mtrl4zHp",
                "https://mp-seoul-image-production-s3.mangoplate.com/787041_1638595367931846.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "듁스커피"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/zVvOCUyTUZDp",
                "https://mp-seoul-image-production-s3.mangoplate.com/722502_1633917525002988.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "오흐뒤구떼"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/d6QJNyRAeUhU",
                "https://mp-seoul-image-production-s3.mangoplate.com/191512_1501744237053225.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "쥬마뺄"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/yGY6XQTTDLtY",
                "https://mp-seoul-image-production-s3.mangoplate.com/329767/24897_1637832854727_62923?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "시루케이크"
            )
        )

        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(baseContext, items)
        recyclerView.adapter = rvAdapter

        rvAdapter.itemClkick = object : RVAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                val intent = Intent(baseContext, ViewActivity::class.java)
                intent.putExtra("url",items[position].url)
                intent.putExtra("title",items[position].titleText)
                intent.putExtra("imageUrl",items[position].imageUrl)
                startActivity(intent)
            }
        }

        //recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.layoutManager = GridLayoutManager(this,2)

    }
}