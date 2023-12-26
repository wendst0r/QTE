package com.example.qte

/**
 * Класс, представляющий пункт выдачи заказа.
 *
 * @property name Название пункта выдачи.
 * @property address Адрес пункта выдачи.
 * @property comment Комментарий к пункту выдачи.
 */
data class PickupPoint(
    val name: String?, // Название пункта выдачи
    val address: String?, // Адрес пункта выдачи
    var comment: String? // Комментарий к пункту выдачи
)


