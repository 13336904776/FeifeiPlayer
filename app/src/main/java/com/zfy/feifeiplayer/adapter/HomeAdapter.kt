package com.zfy.feifeiplayer.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.zfy.feifeiplayer.bean.X
import com.zfy.feifeiplayer.widget.HomeItemView

/**
 *
 */
class HomeAdapter(mContext: Context?, var list: ArrayList<X>) : RecyclerView.Adapter<HomeAdapter.HomeHolder>() {

    //    var list = ArrayList<X>()
    fun updata(mlist: List<X>) {
        list.clear()
        list.addAll(mlist)
        notifyDataSetChanged()
    }

    fun loadMore(mlist: List<X>) {
        list.addAll(mlist)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): HomeHolder {

        return HomeHolder(HomeItemView(p0.context))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(p0: HomeHolder, p1: Int) {
        val data = list[p1]
        val homeItemView = p0.itemView as HomeItemView
        homeItemView.setData(data)
    }

    class HomeHolder(itemView: HomeItemView) : RecyclerView.ViewHolder(itemView) {

    }
}