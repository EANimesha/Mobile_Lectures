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
        class GetTasks:AsyncTask<Void, Void, List<Task>>(){
            override  fun doInBackground(vararg p0: Void?): List<Task> {
                return DatabaseClient.getInstance(applicationContext).appDatabase.taskDao().getAll
            }

            override fun onPostExecute(results: List<Task>?) {
                super.onPostExecute(results)
                var adapter=TasksAdapter(this@MainActivity,results)
                recyclerView?.adapter=adapter

            }
        }
        var gt=GetTasks()
        gt.execute()
    }


}
