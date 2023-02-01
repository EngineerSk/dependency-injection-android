package com.techyourchance.dagger2course

import android.app.Application
import com.techyourchance.dagger2course.common.dependencyInjection.AppComponent
import com.techyourchance.dagger2course.common.dependencyInjection.AppModule
import com.techyourchance.dagger2course.common.dependencyInjection.DaggerAppComponent

class MyApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule()).build()
        super.onCreate()
    }

}