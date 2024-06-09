package com.bemos.notescompose.ui.app

import android.app.Application
import com.bemos.notescompose.ui.di.AppComponent
import com.bemos.notescompose.ui.di.DaggerAppComponent
import com.bemos.notescompose.ui.di.modules.AppModule

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }

}