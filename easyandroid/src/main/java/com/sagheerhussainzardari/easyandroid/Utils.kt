package com.sagheerhussainzardari.easyandroid

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

//Shows simple short toast
fun Context.showToastShort(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

//Shows simple long toast
fun Context.showToastLong(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

// makes any View VISIBLE
fun View.show() {
    visibility = View.VISIBLE
}

// makes any View GONE
fun View.hide() {
    visibility = View.GONE
}

//only check if this is string is valid email or not
fun isEmailValid(email: String): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

//check the editText for valid email and return true other wise shows error msg and returns false
fun isEmailValid(email: EditText): Boolean {

    if (Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()) {
        return true
    } else {
        email.error = "Enter Valid Email Address!!"
        email.requestFocus()
        return false
    }
}

//only check if this is string is valid password or not
fun isPhoneValid(phone: String): Boolean {
    return Patterns.PHONE.matcher(phone).matches()
}

//check the editText for valid phone and return true other wise shows error msg and returns false
fun isPhoneValid(phone: EditText): Boolean {

    if (Patterns.EMAIL_ADDRESS.matcher(phone.text.toString()).matches()) {
        return true
    } else {
        phone.error = "Enter Valid Phone Number!!"
        phone.requestFocus()
        return false
    }
}

//returns current date in string format "29-06-2020"
fun getCurrentDate(): String {
    val sdf = SimpleDateFormat("dd/M/yyyy")
    val currentDate = sdf.format(Date())
    return currentDate
}

//returns current time in string format "11:25:00"
fun getCurrentTime(): String {
    val sdf = SimpleDateFormat("HH:MM:SS")
    val currentDate = sdf.format(Date())
    return currentDate
}

//returns current date and time in string format "29-06-2020 11:25:00"
fun getCurrentDateTime(): String {
    val sdf = SimpleDateFormat("dd/M/yyyy HH:MM:SS")
    val currentDate = sdf.format(Date())
    return currentDate
}

//Checks If Connected to Any Network
fun isConnectedToInternet(context: Context): Boolean {

    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
    if (capabilities != null) {
        if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
            return true
        } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
            return true
        }
    }
    return false
}

//Checks If Connected to Wifi Network
fun isConnectedToWifi(context: Context): Boolean {

    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
    if (capabilities != null) {
        if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
            return true
        }
    }
    return false
}

//Checks If Connected to Mobile Network
fun isConnectedToMobile(context: Context): Boolean {

    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
    if (capabilities != null) {
        if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
            return true
        }
    }
    return false
}