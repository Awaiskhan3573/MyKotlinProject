package com.note.app.mykotlinproject.roomdatabase.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.room.RoomDatabase
import com.note.app.mykotlinproject.R
import com.note.app.mykotlinproject.roomdatabase.callback.ClickAbleCallBack
import com.note.app.mykotlinproject.roomdatabase.model.DataModel

class DataAdapter (
    val context: Context,
    private val list: ArrayList<DataModel>,val callback:ClickAbleCallBack
) :
    RecyclerView.Adapter<DataAdapter.ViewHolder>() {



    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(p0.context)
                .inflate(R.layout.data_show_design, p0, false) as View
        )
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val data = list[position]

        holder.date.text= data.Date
        holder.time.text=data.Time
        holder.paidBy.text=data.PaidBy
        holder.amount.text=data.Amount
        holder.type.text=data.typeFood
        holder.delete.setOnClickListener {
            callback.itemClick(position)

        }
        }


    override fun getItemCount(): Int {
        return list.size

    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
      val date : TextView=view.findViewById(R.id.date)
      val time : TextView=view.findViewById(R.id.time)
      val paidBy : TextView=view.findViewById(R.id.paidBy)
      val amount : TextView=view.findViewById(R.id.amount)
      val type : TextView=view.findViewById(R.id.type)
      val delete :ImageView=view.findViewById(R.id.btnDelete)


    }
}