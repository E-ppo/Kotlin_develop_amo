package com.example.rv_ex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(val items :MutableList<String>) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item,parent,false)
        return ViewHolder(view)
    }

    //메인 엑티비티에 셋온아이템클릭 이벤트가 활성화 안됨(리스트뷰에는 있는데...)
    //어뎁터에서 직접 선언해줄 필요가 있음
    interface ItemClick{
        fun onClkick(view : View, position: Int)
    }
    var itemClick : ItemClick? = null

    override fun onBindViewHolder(holder: RVAdapter.ViewHolder, position: Int) {
        if(itemClick != null){
            holder.itemView.setOnClickListener { v->
                itemClick?.onClkick(v,position)
            }
        }
        holder.bindItems(items[position])
    }

    //전체 리사이클러뷰의 개수
    override fun getItemCount(): Int {
         return items.size
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bindItems(item : String) {
            val rv_text = itemView.findViewById<TextView>(R.id.rvItem)
            rv_text.text = item
        }

    }
}