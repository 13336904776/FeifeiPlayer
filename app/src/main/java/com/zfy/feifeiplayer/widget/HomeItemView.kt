package com.zfy.feifeiplayer.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.squareup.picasso.Picasso
import com.zfy.feifeiplayer.R
import com.zfy.feifeiplayer.bean.X
import kotlinx.android.synthetic.main.item_home.view.*
import org.jetbrains.anko.image

/**
 *
 */
class HomeItemView :RelativeLayout{
    fun setData(data: X) {
        Picasso.with(context)
                .load(data.shopOrderGoodsDetailsList[0].resourceInfo.urlFrameCapture)
                .into(bg)
        title.setText(data.shopOrderGoodsDetailsList[0].goodsName)
    }

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        View.inflate(context, R.layout.item_home,this)
    }
}