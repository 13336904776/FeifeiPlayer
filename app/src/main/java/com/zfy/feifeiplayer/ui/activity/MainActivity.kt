package com.zfy.feifeiplayer.ui.activity

import android.support.v7.widget.Toolbar
import android.widget.FrameLayout
import com.roughike.bottombar.OnTabSelectListener
import com.zfy.feifeiplayer.R
import com.zfy.feifeiplayer.base.BaseActivity
import com.zfy.feifeiplayer.util.FragmentUtil
import com.zfy.feifeiplayer.util.ToolbarManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.find

class MainActivity : BaseActivity(),ToolbarManager {
    override val toolbar: Toolbar by lazy {
        find<Toolbar>(R.id.toolbar)
    }
    override fun getlayoutId(): Int {
        return R.layout.activity_main
    }

//    val framelayout by lazy { find<FrameLayout>(R.id.framelayout) }

    override fun initData() {
        super.initData()
        initMainToolBar()

    }

    override fun initListener() {
        super.initListener()

        bottomBar.setOnTabSelectListener{
            val beginTransaction = supportFragmentManager.beginTransaction()
            beginTransaction.replace(R.id.framelayout, FragmentUtil.fragmentUtil.swithFragment(it)!!,it.toString())
            beginTransaction.commit()
        }
    }
}
