package com.techyourchance.dagger2course.common.dependencyInjection.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import dagger.Component

@ActivityScope
@Component(modules = [ActivityModule::class])
interface ActivityComponent {
    fun activity(): AppCompatActivity
    fun screensNavigator(): ScreensNavigator
    fun fragmentManager(): FragmentManager
    fun layoutInflater(): LayoutInflater
    fun stackoverflowApi(): StackoverflowApi
}