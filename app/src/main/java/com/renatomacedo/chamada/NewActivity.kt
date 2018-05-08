package com.renatomacedo.chamada

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateUtils.LENGTH_LONG
import android.view.View
import android.widget.*
import android.widget.Toast.LENGTH_LONG
import kotlinx.android.synthetic.main.activity_new.*


class NewActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        button2.setOnClickListener{
            val intent = Intent (this,NewActivity2::class.java)
            startActivity(intent)
        }
/*
        button.setOnClickListener{
            val intent = Intent (this,NewActivity2::class.java)
            startActivity(intent)
        }

        button3.setOnClickListener{
            val intent = Intent (this,NewActivity2::class.java)
            startActivity(intent)
        }
*/

    }

}