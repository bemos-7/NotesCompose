package com.bemos.notescompose.ui.di

import com.bemos.notescompose.ui.di.modules.AppModule
import com.bemos.notescompose.ui.di.modules.DataModule
import com.bemos.notescompose.ui.di.modules.DomainModule
import com.bemos.notescompose.ui.presentation.MainActivity
import dagger.Component

@Component(
    modules = [AppModule::class, DataModule::class, DomainModule::class]
)
interface AppComponent {

    fun inject(mainActivity: MainActivity)

}