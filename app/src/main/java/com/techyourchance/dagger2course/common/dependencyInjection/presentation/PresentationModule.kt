package com.techyourchance.dagger2course.common.dependencyInjection.presentation

import android.view.LayoutInflater
import androidx.fragment.app.FragmentManager
import com.techyourchance.dagger2course.common.dependencyInjection.activity.ActivityComponent
import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.questions.FetchQuestionDetailsUseCase
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import com.techyourchance.dagger2course.screens.common.dialogs.DialogsNavigator
import com.techyourchance.dagger2course.screens.common.viewsmvc.ViewMVCFactory
import dagger.Module
import dagger.Provides

@Module
class PresentationModule(private val activityComponent: ActivityComponent) {

    @Provides
    fun layoutInflater() = activityComponent.layoutInflater()

    @Provides
    fun stackoverflowApi() = activityComponent.stackoverflowApi()

    @Provides
    fun fragmentManager() = activityComponent.fragmentManager()

    @Provides
    fun dialogsNavigator(fragmentManager: FragmentManager) = DialogsNavigator(fragmentManager)


    @Provides
    fun screensNavigator() = activityComponent.screensNavigator()

    @Provides
    fun mvcViewsFactory(layoutInflater: LayoutInflater) = ViewMVCFactory(layoutInflater)

    @Provides
    fun fetchQuestionsUseCase(stackoverflowApi: StackoverflowApi) = FetchQuestionsUseCase(
        stackoverflowApi
    )

    @Provides
    fun fetchQuestionDetailsUseCase(stackoverflowApi: StackoverflowApi) =
        FetchQuestionDetailsUseCase(
            stackoverflowApi
        )
}