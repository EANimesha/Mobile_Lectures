package com.example.a11rooms_new

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: UserListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = UserListAdapter()
        recyclerview_users.layoutManager = LinearLayoutManager(this)
        recyclerview_users.adapter = adapter


        floatingActionButton.setOnClickListener {
            val intent = Intent(this@MainActivity,AddUserActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        val repo = UserRepository(this)
        val allUsers = repo.getAllUsers()
        adapter.setUsers(allUsers)

    }
}
