package com.zfy.feifeiplayer.bean

/**
 *
 */
data class HomeBean(
    val `data`: Data,
    val msg: String,
    val statusCode: Int,
    val success: Boolean
)

data class Data(
    val list: List<X>,
    val pageNum: Int,
    val pageSize: Int,
    val pages: Int,
    val total: Int
)

data class X(
    val createDate: String,
    val discountAmount: Int,
    val dispatcherCode: String,
    val evaluationState: Int,
    val goodsAmount: Double,
    val goodsSum: Int,
    val isStockUp: Int,
    val orderAmount: Double,
    val orderId: String,
    val orderState: Int,
    val refundOrder: Any,
    val second: Int,
    val shopOrderGoodsDetailsList: List<ShopOrderGoodsDetails>,
    val state: String,
    val storeId: String,
    val storeName: String,
    val store_valid: Int,
    val way: String
)

data class ShopOrderGoodsDetails(
    val buyNum: Int,
    val buyerId: String,
    val createTime: String,
    val createUser: String,
    val goodsBrokerage: Int,
    val goodsId: String,
    val goodsImage: Any,
    val goodsName: String,
    val goodsPrice: Double,
    val goodsSpecification: String,
    val goodsType: Int,
    val goodsUnit: String,
    val goodsWeight: Any,
    val id: String,
    val isRefund: Int,
    val isValid: Int,
    val orderId: String,
    val refundOrderId: Any,
    val resourceInfo: ResourceInfo,
    val shopStoreId: String,
    val totalPrice: Double,
    val updateTime: Any,
    val updateUser: Any
)

data class ResourceInfo(
    val createTime: String,
    val createUser: String,
    val description: Any,
    val duration: Any,
    val fileType: Int,
    val hashKey: String,
    val height: Int,
    val heightFrameCapture: Any,
    val id: String,
    val isCover: Any,
    val isValid: Int,
    val purposeType: String,
    val relationId: String,
    val sequence: Any,
    val size: Int,
    val suffixType: String,
    val updateTime: Any,
    val updateUser: Any,
    val url: String,
    val urlFrameCapture: String,
    val urlToken: String,
    val width: Int,
    val widthFrameCapture: Any
)