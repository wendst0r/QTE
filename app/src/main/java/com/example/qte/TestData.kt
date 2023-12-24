package com.example.qte

import java.sql.Time

var clients = listOf<Client>(
    Client("Анон", "ул Нижняя, 2", 4, 17, "666", "Нету", "89998887766", "Домофон не работает, консьерж олень, жди чуда"),
    Client("Котя", "ул Дальняя, 999ж", null, 1, "null", null, "88887776655", "Стучите по забору громко, звонок не работает"),
    Client("пппп", "СНТ Заря, ул 3-я, 2", 1, 1, "1", "", null, "Во дворе злая собака"),
    Client(null, "ул. 30 лет Победы, 100", 1, 1, "Дурка", null, null, "Пей таблетки"),
    Client("Иван Иванов", "Некорректный адрес", null, null, "null", null, "88005553535", "Оставьте заказ у двери"))

var pickupPoints = listOf<PickupPoint>(
    PickupPoint("Суши в яме", "улица Карла Маркса, 291", "Подвальчик на торце дома со стороны Кирова"),
    PickupPoint("Старик Хинкалыч", "Пушкинская, 252", "Время ожидания от 30 минут, жди заказ на скамейка у входа"),
    PickupPoint("Cocos launge", "ул. Коммунаров, 224Д", "В нашем подвале не ловит инет, сори"),
    PickupPoint("Пятерочка", "ул. 30 лет Победы, 26", "По поводу заказа звоните менеджеру: +7-800-555-35-35"),
    PickupPoint("Ростикс (KFC)", "Школьная ул., 43", "Пожалуйста, не повредите заказ"))

var orders = listOf<Order>(
    Order("12:20", "12:40", pickupPoints[0], clients[4], "Суши подвальные с тараканами", OrderStatus.ord_await),
    Order("19:45", "20:00", pickupPoints[1], clients[3], "Холодные хинкали и хачапури по аджарски всмятку", OrderStatus.ord_await),
    Order("10:00", "10:30", pickupPoints[2], clients[2], "", OrderStatus.ord_delivered),
    Order("13:13", "14:14", pickupPoints[3], clients[1], "Две пятилитровки и 15 кг соли", OrderStatus.ord_delivered),
    Order("14:14", "15:15", pickupPoints[4], clients[0], "Салфетка", OrderStatus.pickup_point),
    Order("12:20", "12:40", pickupPoints[0], clients[4], "Суши подвальные с тараканами", OrderStatus.ord_await),
    Order("19:45", "20:00", pickupPoints[1], clients[3], "Холодные хинкали и хачапури по аджарски всмятку", OrderStatus.ord_await),
    Order("10:00", "10:30", pickupPoints[2], clients[2], "", OrderStatus.ord_delivered),
    Order("13:13", "14:14", pickupPoints[3], clients[1], "Две пятилитровки и 15 кг соли", OrderStatus.ord_delivered),
    Order("14:14", "15:15", pickupPoints[4], clients[0], "Салфетка", OrderStatus.pickup_point)

)