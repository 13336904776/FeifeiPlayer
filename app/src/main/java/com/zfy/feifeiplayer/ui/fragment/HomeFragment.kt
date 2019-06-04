package com.zfy.feifeiplayer.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.zfy.feifeiplayer.R
import com.zfy.feifeiplayer.adapter.HomeAdapter
import com.zfy.feifeiplayer.base.BaseFragment
import com.zfy.feifeiplayer.util.URLProviderUtils
import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.*
import org.jetbrains.anko.debug
import java.io.IOException


/**
 *
 */
class HomeFragment : BaseFragment() {
    override fun initView(): View {

        return View.inflate(context, R.layout.fragment_home, null)
    }

    override fun init() {
        super.init()

    }

    override fun initListener() {
        super.initListener()
        rcv.layoutManager = LinearLayoutManager(context)
        var homeAdapter = HomeAdapter(context)
        rcv.adapter = homeAdapter
    }

    override fun initData() {
        super.initData()
        getdata()
    }

    private fun getdata() {
//        val homeUrl = URLProviderUtils.getHomeUrl(0, 20)
        val homeUrl = "https://testapi.hngxsj.com/scsj-baseinfo/appStoreOperations/selectAppGoodsByStoreAndClass"

        val okHttpClient = OkHttpClient()

        val recontent = "{\"goodsClassId\":\"b5ca979634e611e99be17cd30adfe31a|04\",\"storeId\":\"b5ca979634e611e99be17cd30adfe31a\"}"
        val requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),recontent)
        val token = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxNjYzODEzNzcyOCIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTU1OTY0MTU2MTIwNSwiZXhwIjoxNTYwMjQ2MzYxfQ.BKP7Vx2RW_ehPk_KnDLrcDrsX61gfb3QmYTj6Lbb5NYitZDwyEAtYjMXxFJMOgENe-SLJ4jV4geRSqEeSGM3kQ"
        val request = Request.Builder()
                .url(homeUrl)
                .addHeader("Authorization",token)
                .post(requestBody)
                .build()
        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                debug { "网络请求失败==》"+e.message }
                Log.e("zz","网络请求失败=2=》"+e.message)
            }

            override fun onResponse(call: Call, response: Response) {
                debug ( "网络请求成功==》"+response.toString() )
                Log.e("zz","网络请求成功=2=》"+response.body()?.string())
            }

        })


    }
}