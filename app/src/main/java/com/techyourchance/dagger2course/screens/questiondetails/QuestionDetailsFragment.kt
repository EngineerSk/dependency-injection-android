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
import com.techyourchance.dagger2course.screens.common.viewsmvc.ViewMVCFactory
import kotlinx.coroutines.*
import javax.inject.Inject

class QuestionDetailsFragment : BaseFragment(), QuestionDetailsViewMVC.Listener {

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    @Inject lateinit var fetchQuestionDetailsUseCase: FetchQuestionDetailsUseCase
    @Inject lateinit var dialogsNavigator: DialogsNavigator
    @Inject lateinit var screensNavigator: ScreensNavigator
    @Inject lateinit var viewMVCFactory: ViewMVCFactory

    private lateinit var questionId: String

    private lateinit var questionDetailsViewMVC: QuestionDetailsViewMVC

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
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
        questionDetailsViewMVC = viewMVCFactory.newQuestionDetailsViewMVC(container)
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