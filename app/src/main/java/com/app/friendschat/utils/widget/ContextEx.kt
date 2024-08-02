package com.app.friendschat.utils.widget

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.ContextWrapper

fun Context.showDialog(
    title: String,
    message: String,
    textOfNegativeButton: String? = null,
    textOfPositiveButton: String,
    positiveButtonFunction: () -> Unit,
    negativeButtonFunction: (() -> Unit)? = null
){
    val builder = AlertDialog.Builder(this)
    builder.setTitle(title)
    builder.setMessage(message)
    if (textOfNegativeButton != null) {
        builder.setNegativeButton(
            textOfNegativeButton
        ) { dialog, id ->
            if (negativeButtonFunction != null) {
                negativeButtonFunction()
            }
            dialog.dismiss()
        }
    }
    builder.setPositiveButton(
        textOfPositiveButton
    ) { dialog, id ->
        positiveButtonFunction()
        dialog.dismiss()
    }
    val alert = builder.create()
    alert.show()
}

fun Context.findActivity(): Activity? {
    var context = this
    while (context is ContextWrapper) {
        if (context is Activity) return context
        context = context.baseContext
    }
    return null
}