package com.sagheerhussainzardari.shz


import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

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

fun getCurrentDate(): String {
    val sdf = SimpleDateFormat("dd/M/yyyy")
    val currentDate = sdf.format(Date())
    return currentDate
}

fun getCurrentTime(): String {
    val sdf = SimpleDateFormat("HH:MM:SS")
    val currentDate = sdf.format(Date())
    return currentDate
}

fun getCurrentDateTime(): String {
    val sdf = SimpleDateFormat("dd/M/yyyy HH:MM:SS")
    val currentDate = sdf.format(Date())
    return currentDate
}


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


//fun isOnline(context: Context): Boolean {
//    val connectivityManager =
//        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//    if (connectivityManager != null) {
//        val capabilities =
//            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
//        if (capabilities != null) {
//            if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
//                Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
//                return true
//            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
//                Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
//                return true
//            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
//                Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
//                return true
//            }
//        }
//    }
//    return false
//}