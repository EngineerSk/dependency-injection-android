package com.techyourchance.dagger2course

import android.app.Application
import com.techyourchance.dagger2course.common.dependencyInjection.app.AppComponent
import com.techyourchance.dagger2course.common.dependencyInjection.app.AppModule
import com.techyourchance.dagger2course.common.dependencyInjection.app.DaggerAppComponent

class MyApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
        super.onCreate()
    }

}