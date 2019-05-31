package com.zfy.feifeiplayer.util

import com.zfy.feifeiplayer.R
import com.zfy.feifeiplayer.base.BaseFragment
import com.zfy.feifeiplayer.ui.fragment.HomeFragment
import com.zfy.feifeiplayer.ui.fragment.MVFragment
import com.zfy.feifeiplayer.ui.fragment.VBangFragment
import com.zfy.feifeiplayer.ui.fragment.YueDanFragment

/**
 *
 */
class FragmentUtil private constructor() {

    val homeFragment: HomeFragment by lazy {
        HomeFragment()
    }

    val mVFragment: MVFragment by lazy {
        MVFragment()
    }

    val vBangFragment: VBangFragment by lazy {
        VBangFragment()
    }

    val yueDanFragment: YueDanFragment by lazy {
        YueDanFragment()
    }

    companion object {
        val fragmentUtil by lazy { FragmentUtil() }
    }

    fun swithFragment(tabId: Int): BaseFragment? {
        when (tabId) {
            R.id.tab_home -> return homeFragment
            R.id.tab_mv -> return mVFragment
            R.id.tab_vbang -> return vBangFragment
            R.id.tab_yuedan -> return yueDanFragment
            else -> return null
        }
    }
}