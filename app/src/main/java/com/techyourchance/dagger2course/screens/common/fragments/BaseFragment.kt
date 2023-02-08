package com.techyourchance.dagger2course.screens.common.fragments

import androidx.fragment.app.Fragment
import com.techyourchance.dagger2course.common.dependencyInjection.presentation.PresentationComponent
import com.techyourchance.dagger2course.common.dependencyInjection.presentation.PresentationModule
import com.techyourchance.dagger2course.common.dependencyInjection.presentation.UseCasesModule
import com.techyourchance.dagger2course.screens.common.activities.BaseActivity

open class BaseFragment : Fragment() {

    private val presentationComponent by lazy {
        (requireActivity() as BaseActivity).activityComponent.newPresentationComponent(
            PresentationModule(), UseCasesModule()
        )
    }

    protected val injector: PresentationComponent get() = presentationComponent
}