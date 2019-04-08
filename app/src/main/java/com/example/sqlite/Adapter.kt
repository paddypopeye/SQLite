package com.example.sqlite

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class Adapter(var context: Context, data: ArrayList<Subject_Class>) : RecyclerView.Adapter<Adapter.ViewHolder>(){

    var data:ArrayList<Subject_Class>

    init {

        this.data = data
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = data[position].title
        holder.desc.text = data[position].desc
        holder.id.text = data[position].id

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layout = LayoutInflater.from(context).inflate(R.layout.item_subject, parent, false)
        return ViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item){

        var title: TextView
        var id: TextView
        var desc: TextView

        init {
            title = item.findViewById<TextView>(R.id.title_txtView)
            id = item.findViewById(R.id.txt_id)
            desc = item.findViewById(R.id.desc_txtView)
        }
    }
}