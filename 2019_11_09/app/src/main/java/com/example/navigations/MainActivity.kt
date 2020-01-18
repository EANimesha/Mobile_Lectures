package com.example.navigations

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //basic intent

//        btn.setOnClickListener {
//            val intent= Intent(this,SecondActivity::class.java)
//            startActivity(intent)
//        }

//        explicit intent data passing
        btn.setOnClickListener {
            val intent= Intent(this,SecondActivity::class.java)
            intent.putExtra("name",editText.text.toString())
            startActivity(intent)
        }

        //implicit intent data passing
//        btn.setOnClickListener {
//            val intent= Intent()
//            intent.action=Intent.ACTION_SEND
//            intent.putExtra(Intent.EXTRA_TEXT,editText.text.toString())
//
//            startActivity(Intent.createChooser(intent,"Share To: "))
//        }
    }

}
