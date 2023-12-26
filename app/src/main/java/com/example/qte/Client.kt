package com.example.qte

/**
 * Data-класс, представляющий клиента.
 *
 * @property name Имя клиента.
 * @property address Адрес клиента.
 * @property entranceNum Номер подъезда.
 * @property floorNum Номер этажа.
 * @property flatNum Номер квартиры.
 * @property intercomCode Код домофона.
 * @property phone Номер телефона клиента.
 * @property comment Комментарий к заказу.
 */
data class Client(
    val name: String?, // имя клиента
    val address: String?, // адрес клиента
    val entranceNum: Int?, // подъезд
    val floorNum: Int?, // этаж
    val flatNum: String?, // квартира
    val intercomCode: String?, // код домофона
    val phone: String?, // номер телефона
    val comment: String? // комментарий к заказу
)