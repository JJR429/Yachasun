package com.cappstudios.yachasun

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.cappstudios.yachasun.model.User
import com.cappstudios.yachasun.network.Callback
import com.cappstudios.yachasun.network.FirestoreService
import com.cappstudios.yachasun.network.USER_COLLECTION_NAME
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_login.*

class Login : Activity() {

    private val TAG="Login"
    private var auth: FirebaseAuth =FirebaseAuth.getInstance()
    lateinit var firestoreService: FirestoreService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        firestoreService= FirestoreService(FirebaseFirestore.getInstance())
        val btnLogin=findViewById<Button>(R.id.SingUpButton)

        onStartClicked(btnLogin)
    }

    fun onStartClicked(view: View)
    {
        //title="Autentificacion"
        SingUpButton.setOnClickListener{
            view.isEnabled=false

            auth.signInAnonymously().addOnCompleteListener{task ->
                if(task.isSuccessful){
                    val Nikname=NickNameEditText.text.toString()
                    val user= User()
                    user.nikname=Nikname
                    saveUserAndshowHome(user,view)
                }else{
                    showAlert(view)
                    view.isEnabled=true
                }
            }
        }
    }

    private fun saveUserAndshowHome(user: User, view: View) {
        firestoreService.setDocument(user, USER_COLLECTION_NAME,user.nikname,object: Callback<Void> {

            override fun onSuccess(result: Void?){
                showHome(user.nikname)
            }
            override fun onFailed(exception: Exception){
                showAlert(view)
                Log.e(TAG,"ERROR",exception)
                view.isEnabled=true
            }
        })
    }

    private fun showAlert(view:View){
        Snackbar.make(view,"Error mienstras la conexion al servidor",Snackbar.LENGTH_LONG)
            .setAction("Info",null).show()
    }

    private fun showHome(nickname: String){
        val homeIntent = Intent(this,MainActivity::class.java).apply {
            putExtra("nickname",nickname)
            //putExtra("provider",provider.name)
        }
        startActivity(homeIntent)
    }
}
