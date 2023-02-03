package com.techyourchance.dagger2course.common.dependencyInjection.presentation

import com.techyourchance.dagger2course.screens.questiondetails.QuestionDetailsFragment
import com.techyourchance.dagger2course.screens.questionslist.QuestionsListFragment
import dagger.Component

@Component(modules = [PresentationModule::class])
interface PresentationComponent {
    fun inject(fragment: QuestionsListFragment)
    fun inject(fragment: QuestionDetailsFragment)
}