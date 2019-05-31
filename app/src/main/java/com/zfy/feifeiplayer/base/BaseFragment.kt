package com.zfy.feifeiplayer.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug
import org.jetbrains.anko.runOnUiThread
import org.jetbrains.anko.toast

/**
 *
 */
abstract class BaseFragment : Fragment(),AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initListener()
        initData()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return initView()
    }

    open protected fun init() {
        debug { "oncreat->init" }
    }

    abstract fun initView():View

   open protected fun initListener() {
        debug { "onCreateView->initListener" }
    }

   open protected fun initData() {
        debug { "onCreateView->initData" }
    }

    fun myToast(msg: String) {
        context!!.runOnUiThread { toast(msg) }
    }
}