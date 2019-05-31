package com.zfy.feifeiplayer.util

import android.content.Intent
import android.support.v7.widget.Toolbar
import com.zfy.feifeiplayer.R
import com.zfy.feifeiplayer.ui.activity.SettingActivity

/**
 *
 */
interface ToolbarManager {
    val toolbar: Toolbar

    fun initMainToolBar() {
        toolbar.setTitle("飞飞影音")
        toolbar.inflateMenu(R.menu.main)
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.setting -> {
                    toolbar.context.startActivity(Intent(toolbar.context, SettingActivity::class.java))
                }
            }
            true
        }
    }


    fun initSettingToolbar(){
        toolbar.setTitle("设置界面")
    }
}