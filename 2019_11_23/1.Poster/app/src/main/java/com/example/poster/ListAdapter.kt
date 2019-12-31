package com.example.poster

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class ListAdapter(val userList:List<Person>):RecyclerView.Adapter<ListAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v=LayoutInflater.from(parent?.context).inflate(R.layout.list_layout,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user: Person = userList[position]
        holder?.tvi?.text= user.userId.toString()
        holder?.tvid?.text= user.id.toString()
        holder?.tvt?.text= user.title
        holder?.tvb?.text= user.body

    }

    class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val tvi=itemView.findViewById(R.id.texti) as TextView
        val tvid=itemView.findViewById(R.id.textid) as TextView
        val tvt=itemView.findViewById(R.id.textt) as TextView
        val tvb=itemView.findViewById(R.id.textb) as TextView
    }
}