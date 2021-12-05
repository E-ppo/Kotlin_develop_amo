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

class YimFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_yim, container, false)

        val items = mutableListOf<String>()
        items.add("사랑은 늘 도망가")
        items.add("별빛 같은 나의 사랑아")
        items.add("이제 나만 믿어요")
        items.add("어느 60대 노부부이야기")
        items.add("미운사랑")
        items.add("가슴은 알죠")
        items.add("붉은 입술")

        val rv = view.findViewById<RecyclerView>(R.id.yimRV)
        val rvAdapter = RVAdapter(items)

        rv.adapter = rvAdapter
        rv.layoutManager = LinearLayoutManager(context)


        view.findViewById<ImageView>(R.id.songG).setOnClickListener(){
            it.findNavController().navigate(R.id.action_yimFragment_to_songFragment)
        }

        view.findViewById<ImageView>(R.id.yongT).setOnClickListener(){
            it.findNavController().navigate(R.id.action_yimFragment_to_youngFragment)
        }
        return view
    }

}