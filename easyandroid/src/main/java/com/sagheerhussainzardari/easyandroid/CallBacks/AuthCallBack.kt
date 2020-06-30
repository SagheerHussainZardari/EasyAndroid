package com.sagheerhussainzardari.easyandroid.CallBacks

interface AuthCallBack {

    fun onLoginSuccess()
    fun onLoginFailed(failureMessage: String)

    fun onSignUpSuccess()
    fun onSignUpFailed(failureMessage: String)

}