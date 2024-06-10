package com.bemos.notescompose.ui.di

import android.content.Context
import com.bemos.notescompose.ui.app.App
import com.bemos.notescompose.ui.di.modules.AppModule
import com.bemos.notescompose.ui.di.modules.DataModule
import com.bemos.notescompose.ui.di.modules.DomainModule
import com.bemos.notescompose.ui.presentation.MainActivity
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        AppModule::class,
        DataModule::class,
        DomainModule::class
    ]
)
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            context: Context
        ): AppComponent
    }
}

val Context.appComponent: AppComponent get() {
    return if (this is App){
        appComponent
    }else {
        applicationContext.appComponent
    }
}