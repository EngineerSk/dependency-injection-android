package com.techyourchance.dagger2course.screens.common.viewsmvc

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes

open class BaseViewMVC<LISTENER_TYPE>(
    layoutInflater: LayoutInflater,
    parent: ViewGroup?,
    @LayoutRes layoutId: Int
) {
    val rootView: View = layoutInflater.inflate(layoutId, parent, false)

    protected val listeners = HashSet<LISTENER_TYPE>()

    protected val context: Context get() = rootView.context

    fun registerListener(listener: LISTENER_TYPE) {
        listeners.add(listener)
    }

    fun unregisterListener(listener: LISTENER_TYPE) {
        listeners.remove(listener)
    }

    protected fun <T : View?> findViewById(@IdRes id: Int): T = rootView.findViewById<T>(id)
}