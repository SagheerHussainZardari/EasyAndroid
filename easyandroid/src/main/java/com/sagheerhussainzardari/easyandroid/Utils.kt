package com.sagheerhussainzardari.easyandroid

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

fun LinearLayout.show(){
    visibility = View.VISIBLE
}

fun LinearLayout.hide(){
    visibility = View.VISIBLE
}

fun ProgressBar.show(){
    visibility = View.VISIBLE
}

fun ProgressBar.hide(){
    visibility = View.VISIBLE
}

fun EditText.show(){
    visibility = View.VISIBLE
}

fun EditText.hide(){
    visibility = View.VISIBLE
}

fun Button.show(){
    visibility = View.VISIBLE
}

fun Button.hide(){
    visibility = View.VISIBLE
}

fun ImageView.show(){
    visibility = View.VISIBLE
}

fun ImageView.hide(){
    visibility = View.VISIBLE
}

fun View.show(){
    visibility = View.VISIBLE
}

fun View.hide(){
    visibility = View.VISIBLE
}




