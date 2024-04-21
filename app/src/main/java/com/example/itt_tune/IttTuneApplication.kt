package com.example.itt_tune

import android.app.Application
import com.example.itt_tune.data.AppContainer
import com.example.itt_tune.data.DefaultAppContainer
class IttTuneApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }


}