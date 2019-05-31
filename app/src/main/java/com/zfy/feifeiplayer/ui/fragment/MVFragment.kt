package com.zfy.feifeiplayer.ui.fragment

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.TextView
import com.zfy.feifeiplayer.base.BaseFragment
import org.jetbrains.anko.debug

/**
 *
 */
class MVFragment: BaseFragment() {
    override fun initView():View {
        debug { "onCreateView->initListener" }
        val tv = TextView(context)
        tv.setText("我是MV")
        tv.gravity = Gravity.CENTER
        tv.textSize = 30f
        tv.setTextColor(Color.BLACK)
        return tv
    }
}