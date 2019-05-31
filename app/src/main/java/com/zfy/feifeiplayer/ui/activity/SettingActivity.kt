package com.zfy.feifeiplayer.ui.activity

import android.support.v7.widget.Toolbar
import com.zfy.feifeiplayer.R
import com.zfy.feifeiplayer.base.BaseActivity
import com.zfy.feifeiplayer.util.ToolbarManager
import org.jetbrains.anko.find

class SettingActivity : BaseActivity(), ToolbarManager {
    override fun getlayoutId(): Int {
        return R.layout.activity_setting
    }

    override val toolbar: Toolbar by lazy {
        find<Toolbar>(R.id.toolbar)
    }

    override fun initListener() {
        super.initListener()
    }

    override fun initData() {
        super.initData()
        initSettingToolbar()
    }
}
