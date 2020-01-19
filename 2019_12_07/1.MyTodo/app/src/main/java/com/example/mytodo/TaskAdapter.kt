package com.example.mytodo

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TasksAdapter(mCtx:Context, taskList: List<Task>?): RecyclerView.Adapter<TasksAdapter.TasksViewHolder>() {
    override fun getItemCount(): Int {
        return taskList.size
    }


    private val mCtx:Context = mCtx
    private val taskList:List<Task> = taskList!!

    override fun onCreateViewHolder(parent:ViewGroup, viewType:Int):TasksViewHolder {
        val view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_tasks, parent, false)
        return TasksViewHolder(view)
    }
    override fun onBindViewHolder(holder:TasksViewHolder, position:Int) {
        val t = taskList[position]
        holder.textViewTask.text = t.task
        holder.textViewDesc.text = t.desc
        holder.textViewFinishBy.text = t.finishBy
        if (t.isFinished)
            holder.textViewStatus.text = "Completed"
        else
            holder.textViewStatus.text = "Not Completed"
    }
    inner class TasksViewHolder(itemView:View):RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var textViewStatus:TextView = itemView.findViewById(R.id.textViewStatus)
        var textViewTask:TextView = itemView.findViewById(R.id.textViewTask)
        var textViewDesc:TextView = itemView.findViewById(R.id.textViewDesc)
        var textViewFinishBy:TextView = itemView.findViewById(R.id.textViewFinishBy)

        init{
            itemView.setOnClickListener(this)
        }
        override fun onClick(view:View) {
            val task = taskList[adapterPosition]
            val intent = Intent(mCtx, UpdateTaskActivity::class.java)
            intent.putExtra("task",task.toString())
            mCtx.startActivity(intent)
        }
    }
}