package com.techyourchance.dagger2course.screens.questiondetails

import android.content.Context
import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.techyourchance.dagger2course.R
import com.techyourchance.dagger2course.screens.common.toolbar.MyToolbar
import com.techyourchance.dagger2course.screens.common.viewsmvc.BaseViewMVC

class QuestionDetailsViewMVC(
    layoutInflater: LayoutInflater,
    parent: ViewGroup?,
    @LayoutRes layoutId: Int = R.layout.layout_question_details
) : BaseViewMVC<QuestionDetailsViewMVC.Listener>(layoutInflater, parent, layoutId) {

    interface Listener {
        fun onBackClicked()
    }

    private val toolbar: MyToolbar = findViewById(R.id.toolbar)
    private val swipeRefresh: SwipeRefreshLayout
    private val txtQuestionBody: TextView = findViewById(R.id.txt_question_body)

    init {

        // init toolbar
        toolbar.setNavigateUpListener {
            for (listener in listeners)
                listener.onBackClicked()
        }

        // init pull-down-to-refresh (used as a progress indicator)
        swipeRefresh = findViewById(R.id.swipeRefresh)
        swipeRefresh.isEnabled = false

    }

    fun bindQuestionBody(questionBody: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            setQuestionTextBody(
                Html.fromHtml(
                    questionBody,
                    Html.FROM_HTML_MODE_LEGACY
                )
            )
        } else {
            @Suppress("DEPRECATION")
            setQuestionTextBody(Html.fromHtml(questionBody))
        }
    }

    private fun setQuestionTextBody(value: CharSequence) {
        setTextViewValue(txtQuestionBody, value)
    }

    private fun setTextViewValue(textView: TextView, value: CharSequence) {
        textView.text = value
    }

    fun showProgressIndication() {
        swipeRefresh.isRefreshing = true
    }

    fun hideProgressIndication() {
        swipeRefresh.isRefreshing = false
    }
}