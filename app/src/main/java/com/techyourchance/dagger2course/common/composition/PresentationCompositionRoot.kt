package com.techyourchance.dagger2course.common.composition

import com.techyourchance.dagger2course.questions.FetchQuestionDetailsUseCase
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import com.techyourchance.dagger2course.screens.common.dialogs.DialogsNavigator
import com.techyourchance.dagger2course.screens.common.viewsmvc.ViewMVCFactory

class PresentationCompositionRoot(private val activityCompositionRoot: ActivityCompositionRoot) {

    private val layoutInflater get() = activityCompositionRoot.layoutInflater

    private val stackoverflowApi get() = activityCompositionRoot.stackoverflowApi

    private val fragmentManager get() = activityCompositionRoot.fragmentManager

    val dialogsNavigator by lazy {
        DialogsNavigator(fragmentManager)
    }

    val screensNavigator get() = activityCompositionRoot.screensNavigator

    val mvcViewsFactory get() = ViewMVCFactory(layoutInflater)

    val fetchQuestionsUseCase: FetchQuestionsUseCase
        get() = FetchQuestionsUseCase(
            stackoverflowApi
        )

    val fetchQuestionDetailsUseCase: FetchQuestionDetailsUseCase
        get() = FetchQuestionDetailsUseCase(
            stackoverflowApi
        )
}