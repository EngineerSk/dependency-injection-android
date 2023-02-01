package com.techyourchance.dagger2course.common.dependencyInjection

import com.techyourchance.dagger2course.networking.StackoverflowApi
import dagger.Component
import retrofit2.Retrofit

@Component(modules = [AppModule::class])
interface AppComponent {
    fun stackoverflowApi(): StackoverflowApi
    fun retrofit(): Retrofit
}