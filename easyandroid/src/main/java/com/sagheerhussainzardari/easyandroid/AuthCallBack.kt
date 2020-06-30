package com.sagheerhussainzardari.easyandroid

interface AuthCallBack {

    fun onLoginSuccess()
    fun onLoginFailed(failureMessage: String)

    fun onSignUpSuccess()
    fun onSignUpFailed(failureMessage: String)

}