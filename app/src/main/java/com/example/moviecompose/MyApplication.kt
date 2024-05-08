package com.example.moviecompose

import android.app.Application
import android.content.Context

//agregar en AndroidManifest.xml -> android:name=".MyApplication"
class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        application = this
    }
    companion object {
        private var application: Application? = null

        private fun getApplication(): Application {
            return application as Application
        }

        fun getContext(): Context {
            return getApplication().applicationContext
        }
    }
}