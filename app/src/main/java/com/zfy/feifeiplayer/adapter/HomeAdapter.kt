package com.zfy.feifeiplayer.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.zfy.feifeiplayer.widget.HomeItemView

/**
 *
 */
class HomeAdapter(mContext:Context?) : RecyclerView.Adapter<HomeAdapter.HomeHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): HomeHolder {
        return HomeHolder(HomeItemView(p0.context))
    }

    override fun getItemCount(): Int {
        return 20
    }

    override fun onBindViewHolder(p0: HomeHolder, p1: Int) {
    }

    class HomeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}