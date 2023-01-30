package com.techyourchance.dagger2course.common.dependencyInjection

import com.techyourchance.dagger2course.screens.questiondetails.QuestionDetailsFragment
import com.techyourchance.dagger2course.screens.questionslist.QuestionsListFragment

class Injector(private val compositionRoot: PresentationCompositionRoot) {
    fun inject(fragment: QuestionDetailsFragment) {
        fragment.fetchQuestionDetailsUseCase = compositionRoot.fetchQuestionDetailsUseCase
        fragment.viewMVCFactory = compositionRoot.mvcViewsFactory
        fragment.screensNavigator = compositionRoot.screensNavigator
        fragment.dialogsNavigator = compositionRoot.dialogsNavigator
    }

    fun inject(fragment: QuestionsListFragment) {
        fragment.fetchQuestionsUseCase = compositionRoot.fetchQuestionsUseCase
        fragment.viewMVCFactory = compositionRoot.mvcViewsFactory
        fragment.screensNavigator = compositionRoot.screensNavigator
        fragment.dialogsNavigator = compositionRoot.dialogsNavigator
    }
}