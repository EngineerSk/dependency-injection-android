package com.techyourchance.dagger2course.screens.questiondetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.techyourchance.dagger2course.R
import com.techyourchance.dagger2course.screens.common.activities.BaseActivity

class QuestionDetailsActivity : BaseActivity() {

    private lateinit var questionId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_frame)

        if (savedInstanceState == null) {
            questionId = intent.extras!!.getString(EXTRA_QUESTION_ID)!!
            supportFragmentManager.beginTransaction()
                .add(R.id.frame_content, QuestionDetailsFragment().apply {
                    arguments = Bundle().apply {
                        putString(EXTRA_QUESTION_ID, questionId)
                    }
                }).commit()
        }
    }

    companion object {
        const val EXTRA_QUESTION_ID = "EXTRA_QUESTION_ID"
        fun start(context: Context, questionId: String) {
            val intent = Intent(context, QuestionDetailsActivity::class.java)
            intent.putExtra(EXTRA_QUESTION_ID, questionId)
            context.startActivity(intent)
        }
    }
}