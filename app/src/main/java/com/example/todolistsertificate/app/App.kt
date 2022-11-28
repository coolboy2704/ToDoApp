package com.example.todolistsertificate.app

import android.app.Application
import com.example.todolistsertificate.di.localStorageModule
import com.example.todolistsertificate.di.networkModule
import com.example.todolistsertificate.di.repositoryModule
import com.example.todolistsertificate.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class App: Application() {
    companion object{
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        val modules = listOf(
            networkModule, viewModelModule, localStorageModule, repositoryModule
        )
        startKoin {
            androidLogger()
            androidContext(this@App)
            androidFileProperties()
            koin.loadModules(modules)
        }
    }
}