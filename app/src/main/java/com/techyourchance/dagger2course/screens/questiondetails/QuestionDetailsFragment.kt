package com.techyourchance.dagger2course.screens.questiondetails

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.techyourchance.dagger2course.questions.FetchQuestionDetailsUseCase
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import com.techyourchance.dagger2course.screens.common.dialogs.DialogsNavigator
import com.techyourchance.dagger2course.screens.common.fragments.BaseFragment
import kotlinx.coroutines.*

class QuestionDetailsFragment : BaseFragment(), QuestionDetailsViewMVC.Listener {

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    private lateinit var questionDetailsViewMVC: QuestionDetailsViewMVC

    private lateinit var fetchQuestionDetailsUseCase: FetchQuestionDetailsUseCase

    private lateinit var dialogsNavigator: DialogsNavigator

    private lateinit var screensNavigator: ScreensNavigator

    private lateinit var questionId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fetchQuestionDetailsUseCase = compositionRoot.fetchQuestionDetailsUseCase

        dialogsNavigator = compositionRoot.dialogsNavigator

        screensNavigator = compositionRoot.screensNavigator

        questionId = arguments?.getString(
            QuestionDetailsActivity.EXTRA_QUESTION_ID
        )!!
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("questionDetailsViewMVC", "onCreateView: called")
        questionDetailsViewMVC =
            compositionRoot.mvcViewsFactory.newQuestionDetailsViewMVC(container)
        return questionDetailsViewMVC.rootView
    }

    override fun onStart() {
        super.onStart()
        Log.d("questionDetailsViewMVC", "onStart: called...")
        questionDetailsViewMVC.registerListener(this)
        fetchQuestionDetails()
    }

    override fun onStop() {
        super.onStop()
        questionDetailsViewMVC.unregisterListener(this)
        coroutineScope.coroutineContext.cancelChildren()
    }

    private fun fetchQuestionDetails() {
        coroutineScope.launch {
            questionDetailsViewMVC.showProgressIndication()
            try {
                when (val result = fetchQuestionDetailsUseCase.fetchQuestionDetails(
                    questionId
                )) {
                    is FetchQuestionDetailsUseCase.Result.Success ->
                        questionDetailsViewMVC.bindQuestionBody(
                            result.questionText
                        )
                    is FetchQuestionDetailsUseCase.Result.Failure -> onFetchFailed()
                }

            } finally {
                questionDetailsViewMVC.hideProgressIndication()
            }

        }
    }

    private fun onFetchFailed() {
        dialogsNavigator.showServerErrorDialog()
    }

    override fun onBackClicked() {
        screensNavigator.navigateBack()
    }
}