package com.techyourchance.dagger2course.common.dependencyInjection.activity

import com.techyourchance.dagger2course.common.dependencyInjection.app.AppComponent
import com.techyourchance.dagger2course.common.dependencyInjection.presentation.PresentationComponent
import com.techyourchance.dagger2course.common.dependencyInjection.presentation.PresentationModule
import dagger.Component

@ActivityScope
@Component(
    dependencies = [AppComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {
    fun newPresentationComponent(presentationModule: PresentationModule): PresentationComponent
}