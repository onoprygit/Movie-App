package com.onopry.movieapp.common

import android.util.Log

fun Any.logDebug(msg: String){
    Log.d("${this.javaClass.simpleName}TAG", msg)
}

fun Any.logError(msg: String){
    Log.e("${this.javaClass.simpleName}TAG", msg)
}

