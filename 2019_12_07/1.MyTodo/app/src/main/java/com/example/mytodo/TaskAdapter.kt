package com.example.mytodo

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TasksAdapter(mCtx:Context, taskList: MutableList<Task>?): RecyclerView.Adapter<TasksAdapter.TasksViewHolder>() {
    override fun getItemCount(): Int {
        return taskList.size
    }


    private val mCtx:Context
    private val taskList:MutableList<Task>

    init{
        this.mCtx = mCtx
        this.taskList = taskList!!
    }
    override fun onCreateViewHolder(parent:ViewGroup, viewType:Int):TasksViewHolder {
        val view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_tasks, parent, false)
        return TasksViewHolder(view)
    }
    override fun onBindViewHolder(holder:TasksViewHolder, position:Int) {
        val t = taskList.get(position)
        holder.textViewTask.setText(t.task)
        holder.textViewDesc.setText(t.desc)
        holder.textViewFinishBy.setText(t.finishBy)
        if (t.isFinished)
            holder.textViewStatus.setText("Completed")
        else
            holder.textViewStatus.setText("Not Completed")
    }
    inner class TasksViewHolder(itemView:View):RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var textViewStatus:TextView
        var textViewTask:TextView
        var textViewDesc:TextView
        var textViewFinishBy:TextView
        init{
            textViewStatus = itemView.findViewById(R.id.textViewStatus)
            textViewTask = itemView.findViewById(R.id.textViewTask)
            textViewDesc = itemView.findViewById(R.id.textViewDesc)
            textViewFinishBy = itemView.findViewById(R.id.textViewFinishBy)
            itemView.setOnClickListener(this)
        }
        override fun onClick(view:View) {
            val task = taskList.get(getAdapterPosition())
            val intent = Intent(mCtx, UpdateTaskActivity::class.java)
            intent.putExtra("task", task)
            mCtx.startActivity(intent)
        }
    }
}