package com.cappstudios.yachasun.model

import android.widget.ImageView

class Usuarios(var nikname:String="",var imageView: ImageView,var puntos: Int =0){
    fun getDocumentId(): String {
        return nikname.toLowerCase()
    }
}