package com.zfy.feifeiplayer.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.zfy.feifeiplayer.bean.X
import com.zfy.feifeiplayer.widget.HomeItemView
import com.zfy.feifeiplayer.widget.LoadMoreView

/**
 *
 */
class HomeAdapter() : RecyclerView.Adapter<HomeAdapter.HomeHolder>() {

    var list = ArrayList<X>()
    fun updata(mlist: List<X>) {
        list.clear()
        list.addAll(mlist)
        notifyDataSetChanged()
    }

    fun loadMore(mlist: List<X>) {
        list.addAll(mlist)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): HomeHolder {
        if (viewType == 1) {
            return HomeHolder(LoadMoreView(p0.context))
        } else {
            return HomeHolder(HomeItemView(p0.context))
        }
    }

    override fun getItemCount(): Int {
        return list.size + 1
    }

    override fun onBindViewHolder(p0: HomeHolder, p1: Int) {
        if (p1 == list.size) return
        val data = list[p1]
        val homeItemView = p0.itemView as HomeItemView
        homeItemView.setData(data)
    }

    override fun getItemViewType(position: Int): Int {
        if (position == list.size) return 1//1 加载更多
        else return 0
    }

    class HomeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}