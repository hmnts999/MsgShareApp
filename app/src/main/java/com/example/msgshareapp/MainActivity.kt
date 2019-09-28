package com.example.msgshareapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowToast.setOnClickListener {
            Log.i("MainActivity", "Button was clicked !")
            Toast.makeText(this, "Button Clicked !", Toast.LENGTH_SHORT).show()
        }

        btnSendMsgToNxtActivity.setOnClickListener {
            val message: String = etUserMsg.getText().toString()
            val intent = Intent(this, SecondActivity::class.java)

            intent.putExtra("user_message", message)

            startActivity(intent)

        }
        btnSharedToOthers.setOnClickListener {
            val message: String = etUserMsg.getText().toString()

            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent,"Share to: "))
        }
    }

}
