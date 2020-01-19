package com.example.a11rooms_new

import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_add_user.*

class AddUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)


        val repo = UserRepository(this)

        button_save_user.setOnClickListener {
            if (ed_username.text.isNotEmpty() && ed_email.text.isNotEmpty() && ed_location.text.isNotEmpty()) {
                val user = Users(
                    userName = ed_username.text.toString(),
                    location = ed_location.text.toString(),
                    email = ed_email.text.toString()
                )
                repo.insertUser(user)
            } else {
                Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show()
            }
            finish()
        }
    }
}
