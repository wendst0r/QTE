package com.example.qte

data class Order(var receiptTime: String?,
                 var deliveryTime: String?,
                 val pickupPoint: PickupPoint,
                 val client: Client,
                 val content: String?,
                 var status: OrderStatus = OrderStatus.ord_await)

