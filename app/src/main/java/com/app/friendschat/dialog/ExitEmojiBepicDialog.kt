package com.app.friendschat.dialog

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
import com.app.friendschat.R
import com.app.friendschat.utils.widget.tapAndCheckInternet

class ExitEmojiBepicDialog(
    activity: Activity,
    private val onQuitBepic: () -> Unit = {},
    private val onSaveDaftBepic: () -> Unit = {}
) : Dialog(activity){

    private lateinit var ivCloseBepic: ImageView
    private lateinit var rlSaveBepic: RelativeLayout
    private lateinit var rlQuitBepic: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window?.setBackgroundDrawableResource(android.R.color.transparent)
        setContentView(R.layout.dialog_exit_emoji_bepic)

        initViewBepic()
        initListenerBepic()
    }

    private fun initViewBepic(){
        ivCloseBepic = findViewById(R.id.iv_close)
        rlQuitBepic = findViewById(R.id.rl_quit)
        rlSaveBepic = findViewById(R.id.rl_save)
    }

    private fun initListenerBepic(){
        ivCloseBepic.tapAndCheckInternet {
            dismiss()
        }

        rlQuitBepic.tapAndCheckInternet {
            onQuitBepic.invoke()
            dismiss()
        }

        rlSaveBepic.tapAndCheckInternet {
            onSaveDaftBepic.invoke()
            dismiss()
        }
    }

}