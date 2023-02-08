package com.techyourchance.dagger2course.common.dependencyInjection.presentation

import android.view.LayoutInflater
import androidx.fragment.app.FragmentManager
import com.techyourchance.dagger2course.screens.common.dialogs.DialogsNavigator
import com.techyourchance.dagger2course.screens.common.viewsmvc.ViewMVCFactory
import dagger.Module
import dagger.Provides

@Module
class PresentationModule {

    @Provides
    fun dialogsNavigator(fragmentManager: FragmentManager) = DialogsNavigator(fragmentManager)

    @Provides
    fun mvcViewsFactory(layoutInflater: LayoutInflater) = ViewMVCFactory(layoutInflater)

}