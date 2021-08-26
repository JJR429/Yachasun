package com.cappstudios.yachasun

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text


class ToRead : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_read)

        val actionBar: ActionBar? = supportActionBar
        if (actionBar != null) {
            actionBar.hide()
        }

        val intent = intent
        val index = intent.getIntExtra("index",0)
        val book_cod = intent.getStringExtra("cod_book")
//        val name = intent.getStringExtra("name")
        val tvTitle = findViewById<TextView>(R.id.textViewTitle)
        tvTitle.setText(book_cod)
        Toast.makeText(this, ("Index: $index"), Toast.LENGTH_SHORT).show()

    }
}
