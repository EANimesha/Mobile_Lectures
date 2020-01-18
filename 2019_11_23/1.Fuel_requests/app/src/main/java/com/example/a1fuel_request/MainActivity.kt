package com.example.a1fuel_request

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable

data class Post( val userId: Int, val id: Int, val title: String, val body: String): Serializable

class MainActivity : AppCompatActivity() {
    lateinit var myResult:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myResult=findViewById(R.id.txt)

        btn.setOnClickListener {
//            basicRequest()



//            requestWithAsync()

//            Thread(Runnable {
//                blockingRequest()
//            }).start()

            responseConvertToObject()

        }
    }



    //basic http call using fuel function


    fun basicRequest(){
        Fuel.get("http://jsonplaceholder.typicode.com/posts/1")
            .response { request, response, result ->
                println(response)
                val (bytes, error) = result
                if (bytes != null) {
                    println("[response bytes] ${String(bytes)}")
                    myResult.text=String(bytes)
                }
            }

    }

    //http call with with async


    fun requestWithAsync(){
        val httpAsync = "http://jsonplaceholder.typicode.com/posts/1"
            .httpGet()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        println(ex)
                    }
                    is Result.Success -> {
                        val data = result.get()
                        println(data)
                        txt.text=data
                    }
                }
            }

        httpAsync.join()
    }



    //http response convert to an object
    fun responseConvertToObject(){
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
                        var postArray = gson.fromJson(data , Array<Post>::class.java).toList()
                        myResult.text=postArray[0].title
                    }
                }
            }

        httpAsync.join()
    }


    //blocking usage with sync
    //so that we have to use function inside a thread

    fun blockingRequest(){
        val (request, response, result) = "http://jsonplaceholder.typicode.com/posts/1"
            .httpGet()
            .responseString()

        when (result) {
            is Result.Failure -> {
                val ex = result.getException()
                println(ex)
            }
            is Result.Success -> {
                val data = result.get()
                println(data)
//                myResult.text=data
            }
        }
    }
}
