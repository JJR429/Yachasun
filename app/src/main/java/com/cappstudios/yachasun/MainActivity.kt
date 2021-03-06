package com.cappstudios.yachasun

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.cappstudios.yachasun.fragments.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar: ActionBar? = supportActionBar
        if (actionBar != null) {
            actionBar.hide()
        }

        replaceFragment(FragmentLevel1())

        val imgview_level_1 = findViewById<ImageView>(R.id.imageViewLevel1)
        val imgview_level_2 = findViewById<ImageView>(R.id.imageViewLevel2)
        val imgview_level_3 = findViewById<ImageView>(R.id.imageViewLevel3)
        val imgview_level_4 = findViewById<ImageView>(R.id.imageViewLevel4)
        imgview_level_1.setOnClickListener {
            replaceFragment(FragmentLevel1())
        }
        imgview_level_2.setOnClickListener {
            replaceFragment(FragmentLevel2())
        }
        imgview_level_3.setOnClickListener {
            replaceFragment(FragmentLevel3())
        }
        imgview_level_4.setOnClickListener {
            replaceFragment(FragmentLevel4())
        }
    }

    private fun replaceFragment(fragment: Fragment) {

        val fmanager: FragmentManager = supportFragmentManager
        val ftransition = fmanager.beginTransaction()
        ftransition.replace(R.id.fragmentContainer, fragment)
        ftransition.commit()
    }

}
