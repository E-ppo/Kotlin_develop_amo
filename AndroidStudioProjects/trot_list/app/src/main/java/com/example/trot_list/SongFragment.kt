package com.example.trot_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class SongFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       val view = inflater.inflate(R.layout.fragment_song, container, false)

        val items = mutableListOf<String>()
        items.add("엄마아리랑")
        items.add("가인이어라")
        items.add("무명배우")
        items.add("진도아리랑")
        items.add("한 많은 대동강")
        items.add("서울의 달")
        items.add("진정인가요")

        val rv = view.findViewById<RecyclerView>(R.id.songRV)
        val rvAdapter = RVAdapter(items)

        rv.adapter = rvAdapter
        rv.layoutManager = LinearLayoutManager(context)

        view.findViewById<ImageView>(R.id.yongT).setOnClickListener(){
            it.findNavController().navigate(R.id.action_songFragment_to_youngFragment)
        }

        view.findViewById<ImageView>(R.id.yimY).setOnClickListener(){
            it.findNavController().navigate(R.id.action_songFragment_to_yimFragment)
        }
        return view
    }
}