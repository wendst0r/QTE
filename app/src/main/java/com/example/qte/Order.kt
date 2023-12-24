package com.example.qte

import java.io.Serializable


data class Order(var receiptTime: String?,
                 var deliveryTime: String?,
                 val pickupPoint: PickupPoint,
                 val client: Client,
                 val content: String?,
                 var status: OrderStatus = OrderStatus.ord_await,
                 var orderId: Int = 0) : Serializable

