package com.techyourchance.dagger2course.common.dependencyInjection

import com.techyourchance.dagger2course.questions.FetchQuestionDetailsUseCase
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import com.techyourchance.dagger2course.screens.common.dialogs.DialogsNavigator
import com.techyourchance.dagger2course.screens.common.viewsmvc.ViewMVCFactory
import dagger.Component

@Component(modules = [PresentationModule::class])
interface PresentationComponent {
    fun dialogsNavigator(): DialogsNavigator
    fun screensNavigator(): ScreensNavigator
    fun mvcViewsFactory(): ViewMVCFactory
    fun fetchQuestionsUseCase(): FetchQuestionsUseCase
    fun fetchQuestionDetailsUseCase(): FetchQuestionDetailsUseCase
}