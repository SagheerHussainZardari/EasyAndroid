package com.sagheerhussainzardari.easyandroid.CallBacks

import com.google.firebase.database.DataSnapshot

interface RealtimeDatabaseCallBack {

    fun onDataStoredSuccess()
    fun onDataStoredFailure(failureMessage: String)
    fun onDataGetSuccess(snapshot: DataSnapshot)
    fun onDataGetFailure(failureMessage: String)
}