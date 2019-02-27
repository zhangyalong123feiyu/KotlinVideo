package com.example.videomodule

import android.app.Service
import android.content.Intent
import android.os.IBinder

class RemoteService :Service() {
    private val iBinder=object :IMyAidlInterface.Stub(){
        override fun add(value1: Int, value2: Int): Int {
           return value1+value2
        }
    }
    override fun onBind(intent: Intent?): IBinder? {
        return iBinder
    }

}