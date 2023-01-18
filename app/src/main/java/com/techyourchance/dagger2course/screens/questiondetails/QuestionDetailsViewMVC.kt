package com.techyourchance.dagger2course.screens.questiondetails

import android.content.Context
import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.techyourchance.dagger2course.R
import com.techyourchance.dagger2course.screens.common.toolbar.MyToolbar

class QuestionDetailsViewMVC(
    private val layoutInflater: LayoutInflater,
    private val parent: ViewGroup?
) {

    interface Listener {
        fun onBackClicked()
    }

    val rootView: View = layoutInflater.inflate(R.layout.layout_question_details, parent, false)
    private val context: Context get() = rootView.context

    private val toolbar: MyToolbar
    private val swipeRefresh: SwipeRefreshLayout
    private val txtQuestionBody: TextView

    private val listeners = HashSet<Listener>()

    init {
        txtQuestionBody = findViewById(R.id.txt_question_body)

        // init toolbar
        toolbar = findViewById(R.id.toolbar)
        toolbar.setNavigateUpListener {
            for (listener in listeners)
                listener.onBackClicked()
        }

        // init pull-down-to-refresh (used as a progress indicator)
        swipeRefresh = findViewById(R.id.swipeRefresh)
        swipeRefresh.isEnabled = false

    }

    private fun <T : View> findViewById(@IdRes id: Int): T = rootView.findViewById(id)

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

    fun registerListener(listener: Listener) {
        listeners.add(listener)
    }

    fun unregisterListener(listener: Listener) {
        listeners.remove(listener)
    }
}