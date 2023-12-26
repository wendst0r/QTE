package com.example.qte


/**
 * Data-класс, представляющий заказ.
 *
 * @property receiptTime Ожидаемое время выдачи заказа.
 * @property deliveryTime Ожидаемое время доставки заказа.
 * @property pickupPoint Пункт выдачи заказа.
 * @property client Клиент, размещающий заказ.
 * @property content Содержимое заказа.
 * @property status Статус заказа. По умолчанию [OrderStatus.ord_await].
 * @property orderId Идентификатор заказа. По умолчанию 0.
 */
data class Order(
    var receiptTime: String?, // ожидаемое время выдачи заказа
    var deliveryTime: String?, // ожидаемое время доставки заказа
    val pickupPoint: PickupPoint, // пункт выдачи заказа
    val client: Client, // клиент
    val content: String?, // содержимое заказа
    var status: OrderStatus = OrderStatus.ord_await, // статус заказа
    var orderId: Int = 0 // id заказа
)

