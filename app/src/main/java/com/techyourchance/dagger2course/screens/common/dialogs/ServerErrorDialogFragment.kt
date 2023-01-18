package com.techyourchance.dagger2course.screens.common.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.techyourchance.dagger2course.R

class ServerErrorDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return with(AlertDialog.Builder(activity)){
            setTitle(R.string.server_error_dialog_title)
            setMessage(R.string.server_error_dialog_message)
            setPositiveButton(R.string.server_error_dialog_button_caption) { _, _ -> dismiss() }
            create()
        }
    }

    companion object {
        fun newInstance(): ServerErrorDialogFragment {
            return ServerErrorDialogFragment()
        }
    }
}