package com.techyourchance.dagger2course.screens.common.viewsmvc

import android.view.LayoutInflater
import android.view.ViewGroup
import com.techyourchance.dagger2course.screens.questiondetails.QuestionDetailsViewMVC
import com.techyourchance.dagger2course.screens.questionslist.QuestionsListViewMVC

class ViewMVCFactory(private val layoutInflater: LayoutInflater) {

    fun newQuestionsListViewMVC(container: ViewGroup?): QuestionsListViewMVC =
        QuestionsListViewMVC(layoutInflater, container)

    fun newQuestionDetailsViewMVC(container: ViewGroup?): QuestionDetailsViewMVC =
        QuestionDetailsViewMVC(layoutInflater, container)

}