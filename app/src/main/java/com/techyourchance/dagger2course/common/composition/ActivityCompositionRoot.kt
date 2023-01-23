package com.techyourchance.dagger2course.common.composition

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import com.techyourchance.dagger2course.screens.common.dialogs.DialogsNavigator
import com.techyourchance.dagger2course.screens.common.viewsmvc.ViewMVCFactory

class ActivityCompositionRoot(
    private val activity: AppCompatActivity,
    appCompositionRoot: AppCompositionRoot
) {
    val screensNavigator by lazy {
        ScreensNavigator(activity)
    }

    val fragmentManager get() = activity.supportFragmentManager

    val dialogsNavigator by lazy {
        DialogsNavigator(fragmentManager)
    }

    val layoutInflater: LayoutInflater get() = LayoutInflater.from(activity)

    val mvcViewsFactory get() = ViewMVCFactory(layoutInflater)

    val stackoverflowApi = appCompositionRoot.stackoverflowApi
}