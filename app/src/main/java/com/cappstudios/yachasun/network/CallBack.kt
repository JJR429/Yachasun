package com.cappstudios.yachasun.network

interface Callback<T>{
    fun onSuccess(result: T?)
    fun onFailed(exception:Exception)
}