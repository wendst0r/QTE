package com.example.qte

/**
 * Перечисление, представляющее статусы заказа.
 *
 * @property displayedName Отображаемое название статуса заказа.
 */
enum class OrderStatus(val displayedName: String) {
    ord_await("Ожидает принятия"), // Заказ ожидает принятия
    way_pickup_point("На пути в пункт выдачи"), // Заказ в пути в пункт выдачи
    pickup_point("В пункте выдачи"), // Заказ в пункте выдачи
    way_to_cliet("На пути к клиенту"), // Заказ в пути к клиенту
    on_place("У клиента"), // Заказ у клиента
    ord_delivered("Отдал заказ") // Заказ успешно доставлен
}
