package com.zfy.feifeiplayer.ui.fragment

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.TextView
import com.zfy.feifeiplayer.base.BaseFragment
import org.jetbrains.anko.debug
import org.jetbrains.anko.textColor

/**
 *
 */
class HomeFragment: BaseFragment() {
    override fun initView():View {
        debug { "onCreateView->initListener" }
        val tv = TextView(context)
        tv.setText("我是首页")
        tv.gravity = Gravity.CENTER
        tv.textSize = 50f
        tv.setTextColor(Color.BLACK)
        return tv
    }
}