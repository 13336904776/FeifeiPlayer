package com.zfy.feifeiplayer.presenter.impl

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.zfy.feifeiplayer.bean.HomeBean
import com.zfy.feifeiplayer.presenter.interf.HomePresenter
import com.zfy.feifeiplayer.util.ThreadUtil
import com.zfy.feifeiplayer.view.HomeView
import okhttp3.*
import java.io.IOException

/**
 *
 */
class HomePresenterImpl(val homeView: HomeView) : HomePresenter {
    var pageNum = 1
    val pageSize = 6
    val homeUrl = "https://testapi.hngxsj.com/scsj-order/appShopOrder/getShopOrderListByTypeForBuyer"
    val token = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxNTAzNjE4Nzk2NSIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTU1OTcyODMzNDAyOCwiZXhwIjoxNTYwMzMzMTM0fQ.2Wh15sscSRe2SmZTAMf_XQtPTtr_ZibstXNWkJSkvl7ARs8y4wweVe607_HkQsc3FwJqJLEhOJsminHKjAaDvw"

    val okHttpClient by lazy { OkHttpClient() }
    override fun getdata() {
        pageNum = 1
        val recontent = "{\"pageInfo\":{\"pageNum\":1,\"pageSize\":$pageSize},\"type\":\"0\"}"

        val requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), recontent)
        val request = Request.Builder()
                .url(homeUrl)
                .addHeader("Authorization", token)
                .post(requestBody)
                .build()
        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                ThreadUtil.runOnMainThread(object : Runnable {
                    override fun run() {
                        homeView.onFailure(e.message)
                    }
                })
                Log.e("zz", "网络请求失败=2=》" + e.message)
            }

            override fun onResponse(call: Call, response: Response) {

                val result = response.body()?.string()
                Log.e("zz", "网络请求成功=2=》" + result)
                val homeBean = Gson().fromJson<HomeBean>(result, object : TypeToken<HomeBean>() {}.type)
                ThreadUtil.runOnMainThread(object : Runnable {
                    override fun run() {
                        homeView.onGetDataSuccess(homeBean)
                    }
                })
            }
        })
    }

    override fun loadmore(pageNum: Int) {
        val recontent = "{\"pageInfo\":{\"pageNum\":$pageNum,\"pageSize\":$pageSize},\"type\":\"0\"}"
        val requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), recontent)
        val request = Request.Builder()
                .url(homeUrl)
                .addHeader("Authorization", token)
                .post(requestBody)
                .build()
        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                ThreadUtil.runOnMainThread(object : Runnable {
                    override fun run() {
                        homeView.onFailure(e.message)
                    }
                })
                Log.e("zz", "网络请求失败=2=》" + e.message)
            }

            override fun onResponse(call: Call, response: Response) {
                val result = response.body()?.string()
                Log.e("zz", "网络请求成功=2=》" + result)
                val homeBean = Gson().fromJson<HomeBean>(result, object : TypeToken<HomeBean>() {}.type)
                ThreadUtil.runOnMainThread(object : Runnable {
                    override fun run() {
                        homeView.onLoadMoreSuccess(homeBean)
                    }
                })
            }

        })
    }
}