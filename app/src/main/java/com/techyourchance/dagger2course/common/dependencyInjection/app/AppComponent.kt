package com.techyourchance.dagger2course.common.dependencyInjection.app

import android.app.Application
import com.techyourchance.dagger2course.networking.StackoverflowApi
import dagger.Component
import retrofit2.Retrofit

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {
    fun stackoverflowApi(): StackoverflowApi
    fun application(): Application
}