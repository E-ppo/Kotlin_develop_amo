package com.example.mango_contents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class BookmarkActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private val contentsModel = mutableListOf<ContentsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bookmark)

        auth = Firebase.auth
        val database = Firebase.database
        val myBookmarkRef = database.getReference("bookmark_ref")

        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(baseContext,contentsModel )
        recyclerView.adapter = rvAdapter

        recyclerView.layoutManager = GridLayoutManager(this,2)



        myBookmarkRef
            .child(auth.currentUser?.uid.toString())
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for(dataMoel in snapshot.children){
                        Log.d("Datamodel", dataMoel.toString())
                        contentsModel.add(dataMoel.getValue(ContentsModel::class.java)!!)
                    }
                    rvAdapter.notifyDataSetChanged() //데이터를 어뎁터에 동기화시킨다.
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e("Bookmark", "DB Error")
                }

            })
    }
}