package com.sagheerhussainzardari.shz


import android.content.Context
import android.text.Layout
import android.view.View
import android.widget.*

fun Context.showToastShort(message: String){
    Toast.makeText(this , message , Toast.LENGTH_SHORT).show()
}

fun Context.showToastLong(message: String){
    Toast.makeText(this , message , Toast.LENGTH_LONG).show()
}



fun View.show(){
    visibility = View.VISIBLE
}

fun View.hide(){
    visibility = View.GONE
}
