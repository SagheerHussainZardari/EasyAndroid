package com.sagheerhussainzardari.shz

import android.content.Context
import android.widget.Toast

//Shows simple short toast
fun Context.showToastShort(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
