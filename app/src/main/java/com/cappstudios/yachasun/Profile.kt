package com.cappstudios.yachasun

import android.app.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_profile.*

/*enum class ProviderType{
    BASIC
}*/
class Profile : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)


        //setup
        val bundle:Bundle?=intent.extras
        val email:String?=bundle?.getString("email")
        val provider:String?=bundle?.getString("provider")
        setup(email ?: "", provider ?: "")
    }

    private fun setup(email:String ,provider:String){
        //title="Inicio"
        EmailTextView.text=email
        ProviderTextView.text=provider

        //cerrar cesion
        LogOutButton.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            onBackPressed()
        }
    }
}
