package com.techyourchance.dagger2course.screens.common.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.techyourchance.dagger2course.screens.common.activities.BaseActivity

open class BaseFragment:Fragment() {

    protected val compositionRoot get() = (requireActivity() as BaseActivity).compositionRoot
}