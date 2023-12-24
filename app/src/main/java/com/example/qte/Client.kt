package com.example.qte

data class Client(
    val name: String? = "User",

    val address: String = "Адрес не указан, лол",
    val entranceNum: Int? = 0,
    val floorNum: Int? = 0,
    val flatNum: String = "Не указан",
    val intercomCode: String? = "Не указан",

    val phone: String? = "Не указан",
    val comment: String? = "Не указан",)