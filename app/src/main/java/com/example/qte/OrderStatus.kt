package com.example.qte

enum class OrderStatus(val displayedName: String) {
    ord_await("Предстоит"),
    way_pickup_point("На пути в пункт выдачи"),
    pickup_point("В пункте выдачи"),
    way_to_pickup_point("На пути к пункту выдачи заказа"),
    way_to_cliet("На пути к клиенту"),
    on_place("У клиента"),
    ord_delivered("Отдал заказ")
}