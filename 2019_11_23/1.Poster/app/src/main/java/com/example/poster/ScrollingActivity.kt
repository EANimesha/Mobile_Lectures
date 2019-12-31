package com.example.poster

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.gson.gsonDeserializer
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_scrolling.*
import kotlinx.android.synthetic.main.content_scrolling.*
import java.io.Serializable

data class Person( val userId: Int, val id: Int, val title: String, val body: String): Serializable

class ScrollingActivity : AppCompatActivity() {
    val recyclerView=findViewById<RecyclerView>(R.id.recycleview)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        setSupportActionBar(toolbar)

        recyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        fab.setOnClickListener { view ->

//            Fuel.get("http://jsonplaceholder.typicode.com/posts/1")
//                .response { request, response, result ->
//                    println(request)
//                    println(response)
//                    val (bytes, error) = result
//                    if (bytes != null) {
//                        println("[response bytes] ${String(bytes)}")
//                    }
//                }



//            Thread(Runnable {
//                val (request, response, result) = "http://jsonplaceholder.typicode.com/posts"
//                    .httpGet()
//                    .responseString()
//
//                when (result) {
//                    is Result.Failure -> {
//                        val ex = result.getException()
//                        println(ex)
//                    }
//                    is Result.Success -> {
//                        val data = result.get()
//                        println(data)
//                    }
//                }
//            }).start()

            val httpAsync = "http://jsonplaceholder.typicode.com/posts"
                .httpGet()
                .responseString { request, response, result ->
                    when (result) {
                        is Result.Failure -> {
                            val ex = result.getException()
                            println(ex)
                        }
                        is Result.Success -> {
                            val data = result.get()

                            val gson = GsonBuilder().create()
                            var packagesArray = gson.fromJson(data , Array<Person>::class.java).toList()
//                            for (i in packagesArray){
////                                println(i)
//                                textc.setText("id="+i.id+"\ntitle="+i.title+"\n")
//                            }
//                            textc.setText(packagesArray.toString()
//                            val adapter=ListAdapter(packagesArray)
//                            recyclerView.adapter=adapter
                        }
                    }
                }

            httpAsync.join()


            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
