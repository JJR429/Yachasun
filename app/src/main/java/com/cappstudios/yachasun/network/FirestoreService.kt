package com.cappstudios.yachasun.network

import com.cappstudios.yachasun.model.User
import com.cappstudios.yachasun.model.Usuarios
import com.google.firebase.firestore.FirebaseFirestore

const val USUARIOS_COLLECTION_NAME="usuarios"
const val USER_COLLECTION_NAME="user"

class FirestoreService (val firebaseFirestore: FirebaseFirestore){
    fun setDocument(data: Any,collectionName: String, id: String,callback: Callback<Void>){
        firebaseFirestore.collection(collectionName).document(id).set(data)
            .addOnSuccessListener { callback.onSuccess(null) }
            .addOnFailureListener { exception -> callback.onFailed(exception)}
    }

    fun updateUser(user: User,callback: Callback<User>?){
        firebaseFirestore.collection(USER_COLLECTION_NAME).document(user.nikname)
            .update("userList",user.usuariosList)
            .addOnSuccessListener { result ->
                if(callback !=null){
                    callback.onSuccess(user)
                }
            }
            .addOnFailureListener { exception -> callback!!.onFailed(exception)}
    }

    fun updateUsuarios(usuarios: Usuarios){
        firebaseFirestore.collection(USUARIOS_COLLECTION_NAME).document(usuarios.getDocumentId())
            .update("Puntos",usuarios.puntos)
    }
}