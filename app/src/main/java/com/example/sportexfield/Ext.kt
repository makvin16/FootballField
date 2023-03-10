package com.example.sportexfield

import android.content.Context
import android.content.res.Resources
import android.util.Log
import android.widget.Toast

fun logger(str: String) {
    Log.d("zm96", str)
}

fun Context.showToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

val Int.dp: Int
    get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

val Float.dp: Float
    get() = (this * Resources.getSystem().displayMetrics.density + 0.5f)