package com.example.mytodo

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_task.*


class AddTaskActivity : AppCompatActivity() {

    private var editTextTask: EditText? = null
    private var editTextDesc: EditText? = null
    private  var editTextFinishBy: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_add_task)
            editTextTask = findViewById(R.id.editTextTask)
            editTextDesc = findViewById(R.id.editTextDesc)
            editTextFinishBy = findViewById(R.id.editTextFinishBy)
            button_save.setOnClickListener{
                saveTask()
            }
    }

    private fun saveTask() {
        val sTask:String=editTextTask?.text.toString().trim()
        val sDesc:String=editTextDesc?.text.toString().trim()
        val sFinishBy :String=editTextFinishBy?.text.toString().trim()

        if (sTask.isEmpty()) {
            editTextTask?.setError("Task required")
            editTextTask?.requestFocus()
            return
        }

        if (sDesc.isEmpty()) {
            editTextDesc?.setError("Desc required")
            editTextDesc?.requestFocus()
            return
        }

        if (sFinishBy.isEmpty()) {
            editTextFinishBy?.setError("Finish by required")
            editTextFinishBy?.requestFocus()
            return
        }

        class SaveTask: AsyncTask<Void, Void, Void>() {
            override fun doInBackground(vararg voids: Void?): Void? {
                var task=Task()
                task?.task=sTask
                task?.desc=sDesc
                task?.finishBy=sFinishBy
                task?.isFinished=false

//                if (task != null) {
                    DatabaseClient.getInstance(applicationContext).appDatabase.taskDao().insert(task)

//                }

                return null
            }

            override fun onPostExecute(result: Void?) {
                super.onPostExecute(result)
                finish()
                startActivity(Intent(applicationContext,MainActivity::class.java))
                Toast.makeText(applicationContext,"Saved",Toast.LENGTH_LONG).show()
            }

        }
        var st=SaveTask()
        st.execute()
//        Toast.makeText(applicationContext,"$sTask ,$sDesc, $sFinishBy ",Toast.LENGTH_LONG).show()
    }
}
