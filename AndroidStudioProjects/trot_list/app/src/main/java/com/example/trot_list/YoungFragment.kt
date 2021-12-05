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


class YoungFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        val view = inflater.inflate(R.layout.fragment_young, container, false)

        val items = mutableListOf<String>()
        items.add("니가 왜 거기서 나와")
        items.add("찐이야")
        items.add("막걸리 한잔")
        items.add("오케이")
        items.add("꼰대라떼")
        items.add("보약 같은 친구")
        items.add("물안개 블루스")

        val rv = view.findViewById<RecyclerView>(R.id.youngRV)
        val rvAdapter = RVAdapter(items)

        rv.adapter = rvAdapter
        rv.layoutManager = LinearLayoutManager(context)

        view.findViewById<ImageView>(R.id.songG).setOnClickListener(){
            it.findNavController().navigate(R.id.action_youngFragment_to_songFragment)
        }

        view.findViewById<ImageView>(R.id.yimY).setOnClickListener(){
            it.findNavController().navigate(R.id.action_youngFragment_to_yimFragment)
        }
        return view
    }
}