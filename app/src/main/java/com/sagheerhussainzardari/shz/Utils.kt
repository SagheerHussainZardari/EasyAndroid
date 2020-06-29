package com.sagheerhussainzardari.shz


import android.content.Context
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast

fun Context.showToastShort(message: String){
    Toast.makeText(this , message , Toast.LENGTH_SHORT).show()
}

fun Context.showToastLong(message: String){
    Toast.makeText(this , message , Toast.LENGTH_LONG).show()
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}


fun isEmailValid(email: String): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

fun isEmailValid(email: EditText): Boolean {

    if (Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()) {
        return true
    } else {
        email.error = "Enter Valid Email Address!!"
        email.requestFocus()
        return false
    }
}


fun isPhoneValid(phone: String): Boolean {
    return Patterns.PHONE.matcher(phone).matches()
}

fun isPhoneValid(phone: EditText): Boolean {

    if (Patterns.EMAIL_ADDRESS.matcher(phone.text.toString()).matches()) {
        return true
    } else {
        phone.error = "Enter Valid Phone Number!!"
        phone.requestFocus()
        return false
    }
}