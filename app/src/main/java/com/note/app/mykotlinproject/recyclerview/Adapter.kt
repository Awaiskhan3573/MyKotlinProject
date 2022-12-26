package com.note.app.mykotlinproject.recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.note.app.mykotlinproject.R
import com.note.app.mykotlinproject.recyclerview.callback.UsingCallBack


class Adapter (
    val context: Context,
    private val list: ArrayList<Model>,
    private val callBack: UsingCallBack
) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {
    var selectedItemPosition:Int=0


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(p0.context)
                .inflate(R.layout.recyclerview_grid_design, p0, false) as View
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]
        holder.title.text= data.title
        holder.img.setImageResource(data.image)
        holder.itemView.setOnClickListener {
            callBack.onClickItem(data,position)
        }
          /* selectedItemPosition=position
            notifyDataSetChanged()
        }
        if (selectedItemPosition==position){
            holder.cardView.setBackgroundResource(R.color.lightBlue)
            holder.title.setTextColor(Color.WHITE)

        }else{
            holder.cardView.setBackgroundResource(R.color.white)
        }*/

    }


    override fun getItemCount(): Int {
        return list.size

    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title : TextView =view.findViewById(R.id.idTVCourse)
        val img:ImageView=view.findViewById(R.id.idIVCourse)
        val cardView:LinearLayout=view.findViewById(R.id.cardView)


    }
}