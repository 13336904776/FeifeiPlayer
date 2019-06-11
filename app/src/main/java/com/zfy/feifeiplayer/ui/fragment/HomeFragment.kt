package com.zfy.feifeiplayer.ui.fragment

import android.graphics.Color
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.zfy.feifeiplayer.R
import com.zfy.feifeiplayer.adapter.HomeAdapter
import com.zfy.feifeiplayer.base.BaseFragment
import com.zfy.feifeiplayer.bean.HomeBean
import com.zfy.feifeiplayer.bean.X
import com.zfy.feifeiplayer.presenter.impl.HomePresenterImpl
import com.zfy.feifeiplayer.view.HomeView
import kotlinx.android.synthetic.main.fragment_home.*


/**
 *
 */
class HomeFragment : BaseFragment(), HomeView {
    override fun onGetDataSuccess(homeBean: HomeBean?) {
        swr?.let { it.isRefreshing = false }
        homeAdapter.updata(homeBean?.data?.list as ArrayList<X>)
    }

    override fun onLoadMoreSuccess(homeBean: HomeBean?) {
        swr?.let { it.isRefreshing = false }
        homeAdapter.loadMore(homeBean?.data?.list as ArrayList<X>)
    }

    override fun onFailure(message: String?) {
        message?.let { myToast(it) }
    }

    var pageNum = 1
    val homeAdapter by lazy { HomeAdapter() }
    var isloadmore = false
    val homePresenterImpl: HomePresenterImpl by lazy { HomePresenterImpl(this) }

    override fun initView(): View {
        return View.inflate(context, R.layout.fragment_home, null)
    }

    override fun init() {
        super.init()

    }

    override fun initListener() {
        super.initListener()
        rcv.layoutManager = LinearLayoutManager(context)
        rcv.adapter = homeAdapter
        swr.setColorSchemeColors(Color.RED, Color.BLUE, Color.WHITE)

        swr.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener {
            homePresenterImpl.getdata()
        })

        rcv.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                when (newState) {
                    RecyclerView.SCROLL_STATE_IDLE -> {
                        val layoutManager = rcv.layoutManager
                        if (layoutManager is LinearLayoutManager) {
                            if (layoutManager.findLastVisibleItemPosition() == homeAdapter.list.size) {
                                homePresenterImpl.loadmore(++pageNum)
                            }
                        }
                    }
                    else -> {
                    }
                }
            }
        })

    }

    override fun initData() {
        super.initData()
        homePresenterImpl.getdata()
    }

}