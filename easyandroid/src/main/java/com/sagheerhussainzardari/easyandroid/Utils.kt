package com.sagheerhussainzardari.easyandroid

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.sagheerhussainzardari.easyandroid.CallBacks.AuthCallBack
import com.sagheerhussainzardari.easyandroid.CallBacks.RealtimeDatabaseCallBack
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


//check is Password Is Greaterthan or equal to given length
fun isPasswordValid(password: EditText, length: Int): Boolean {
    if (password.text.toString().isEmpty()) {
        password.error = "Password Is Empty"
        password.requestFocus()
        return false
    } else {

        if (password.text.toString().length >= length) {
            return true
        } else {
            password.error = "Password Must Be $length Digits Or Long!!!"
            return false
        }
    }
}

//only check if this is string is valid password or not
fun isPhoneValid(phone: String): Boolean {
    return Patterns.PHONE.matcher(phone).matches()
}

//check the editText for valid phone and return true other wise shows error msg and returns false
fun isPhoneValid(phone: EditText): Boolean {

    if (Patterns.PHONE.matcher(phone.text.toString()).matches()) {
        return true
    } else {
        phone.error = "Enter Valid Phone Number!!"
        phone.requestFocus()
        return false
    }
}

//login fucntion for firebaseAuth With Auto Validations
fun loginWithValidation(
    et_email: EditText,
    et_password: EditText,
    mAuth: FirebaseAuth,
    callBack: AuthCallBack
) {
    if (isEmailValid(et_email)) {
        if (et_password.text.toString().isNotEmpty()) {
            mAuth.signInWithEmailAndPassword(et_email.text.toString(), et_password.text.toString())
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        callBack.onLoginSuccess()
                    } else {
                        callBack.onLoginFailed(it.exception!!.localizedMessage)
                    }
                }
        } else {
            et_password.error = "Password Must Not Be Empty"
            et_password.requestFocus()
            callBack.onLoginFailed("Password Is Empty!!!")
        }
    } else {
        callBack.onLoginFailed("There Is Problem With Email Address!!!")
    }
}


//Login With String Email And Password With Not Validation
fun login(email: String, password: String, mAuth: FirebaseAuth, callBack: AuthCallBack) {

    if (email.isNotEmpty() && password.isNotEmpty()) {
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    callBack.onLoginSuccess()
                } else {
                    callBack.onLoginFailed(it.exception!!.localizedMessage)
                }
            }

    } else {
        callBack.onLoginFailed("Email And Password Must Not Be Empty!!!")
    }
}

//SignUp With String Email And Password With Not Validation
fun signUp(email: String, password: String, mAuth: FirebaseAuth, callBack: AuthCallBack) {
    if (email.isNotEmpty() && password.isNotEmpty()) {
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    callBack.onSignUpSuccess()
                } else {
                    callBack.onSignUpFailed(it.exception!!.localizedMessage)
                }
            }
    } else {
        callBack.onLoginFailed("Email And Password Must Not Be Empty!!!")
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

//Open Link In The Browser
fun openLinkInBrowser(url: String, context: Context) {
    val intent = Intent(Intent.ACTION_VIEW)
    intent.data = Uri.parse(url)
    context.startActivity(intent)
}

//set Data In Realtime Database
fun setDataInFirebaseRealtimeDatabase(
    path: DatabaseReference,
    value: String,
    callBack: RealtimeDatabaseCallBack
) {

    path.setValue(value).addOnCompleteListener {
        if (it.isSuccessful)
            callBack.onDataStoredSuccess()
        else
            callBack.onDataStoredFailure(it.exception!!.localizedMessage)

    }

}

//get Data From Realtime Database
fun getDataFromFirebaseRealtimemDatabase(
    path: DatabaseReference,
    callBack: RealtimeDatabaseCallBack
) {
    path.addListenerForSingleValueEvent(object : ValueEventListener {
        override fun onCancelled(error: DatabaseError) {
            callBack.onDataGetFailure("${error.message}")
        }

        override fun onDataChange(snapshot: DataSnapshot) {
            callBack.onDataGetSuccess(snapshot)
        }
    })
}
