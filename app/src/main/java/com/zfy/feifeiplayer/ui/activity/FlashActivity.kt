package com.zfy.feifeiplayer.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewCompat
import android.support.v4.view.ViewPropertyAnimatorListener
import android.view.View
import com.zfy.feifeiplayer.R
import com.zfy.feifeiplayer.base.BaseActivity
import kotlinx.android.synthetic.main.activity_flash.*

class FlashActivity : BaseActivity(), ViewPropertyAnimatorListener {
    override fun getlayoutId(): Int {
        return R.layout.activity_flash
    }

    override fun initData() {
        super.initData()
        ViewCompat.animate(iv_bg).setDuration(2000).scaleX(1f).scaleY(1f).setListener(this)
    }
    override fun onAnimationEnd(p0: View?) {
        startActivtyAndFinish<MainActivity>()
    }

    override fun onAnimationCancel(p0: View?) {
    }

    override fun onAnimationStart(p0: View?) {
    }


}
