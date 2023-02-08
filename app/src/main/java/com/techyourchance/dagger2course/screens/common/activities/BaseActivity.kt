package com.techyourchance.dagger2course.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.MyApplication
import com.techyourchance.dagger2course.common.dependencyInjection.activity.ActivityComponent
import com.techyourchance.dagger2course.common.dependencyInjection.activity.ActivityModule
import com.techyourchance.dagger2course.common.dependencyInjection.presentation.PresentationModule
import com.techyourchance.dagger2course.common.dependencyInjection.presentation.UseCasesModule

open class BaseActivity : AppCompatActivity() {
    private val appComponent get() = (application as MyApplication).appComponent

    val activityComponent: ActivityComponent by lazy {
        appComponent.newActivityComponent(ActivityModule(this))
    }

    private val presentationComponent by lazy {
        activityComponent.newPresentationComponent(PresentationModule(), UseCasesModule())
    }

    protected val injector get() = presentationComponent
}