package com.zfy.feifeiplayer.view

import com.zfy.feifeiplayer.bean.HomeBean

/**
 *
 */
interface HomeView {
    abstract fun onGetDataSuccess(homeBean: HomeBean?)
    abstract fun onLoadMoreSuccess(homeBean: HomeBean?)
    abstract fun onFailure(message: String?)
}