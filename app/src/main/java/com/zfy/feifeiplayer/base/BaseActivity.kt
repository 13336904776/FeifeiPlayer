package com.zfy.feifeiplayer.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 *
 */
abstract class BaseActivity: AppCompatActivity(),AnkoLogger{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getlayoutId())
        initListener()
        initData()

    }





    abstract fun getlayoutId(): Int

    open protected fun initListener() {

    }

    open protected fun initData() {

    }

    fun myToast(msg:String){
        runOnUiThread { toast(msg) }
    }

    inline fun <reified T:BaseActivity>startActivtyAndFinish(){
        this.startActivity<T>()
        finish()
    }
}