package com.example.mytodo

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import com.example.mytodo.Task as Task

class MainActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerview_tasks)
        recyclerView?.layoutManager=LinearLayoutManager(this)

        floating_button_add.setOnClickListener {
            startActivity(Intent(MainActivity@this,AddTaskActivity::class.java))
        }

        getTasks()
    }

    private fun getTasks() {
        class GetTasks:AsyncTask<Void, Void, MutableList<Task>>(){
            override  fun doInBackground(vararg p0: Void?): MutableList<Task> {
                return DatabaseClient.getInstance(applicationContext).appDatabase.taskDao().all
            }

            override fun onPostExecute(result: MutableList<Task>?) {
                super.onPostExecute(result)
                var adapter=TasksAdapter(this@MainActivity,result)
                recyclerView?.adapter=adapter

            }
        }
        var gt=GetTasks()
        gt.execute()
    }


}
