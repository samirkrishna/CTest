package com.has.sam.cej.ctest
import android.app.Application
import android.support.v7.app.AppCompatActivity
import com.firebase.client.Firebase

class Test : Application() {


    override fun onCreate() {
        super.onCreate()
        Firebase.setAndroidContext(this)
    }

}