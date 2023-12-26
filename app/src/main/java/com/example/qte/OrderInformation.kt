package com.example.qte

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import com.example.qte.databinding.ActivityOrderInformationBinding

/**
 * Активность для отображения информации о заказе.
 */
class OrderInformationActivity: ComponentActivity()  {

    // Привязка для макета активности
    private lateinit var binding: ActivityOrderInformationBinding

    /**
     * Метод вызывается при создании активности.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Установка макета для активности
        setContentView(R.layout.activity_order_information)

        // Инициализация привязки для макета
        binding = ActivityOrderInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Заполнение полей информацией о заказе
        binding.apply {
            orderTitle.text = orders[orderIDD].pickupPoint.name
            deliveryTime.text = orders[orderIDD].deliveryTime
            pickupPointAddress.text = orders[orderIDD].pickupPoint.address
            clientAddress.text = orders[orderIDD].client.address
            flat.text = orders[orderIDD].client.flatNum
            floorNum.text = orders[orderIDD].client.floorNum.toString()
            entrance.text = orders[orderIDD].client.entranceNum.toString()
            content.text = orders[orderIDD].content
            clientNameTitle.text = orders[orderIDD].client.name
            comment.text = "Комментарий пункта выдачи:\n" + orders[orderIDD].pickupPoint.comment +
                    "\n\nКомментарий клиента:\n" + orders[orderIDD].client.comment
        }

        // Скрытие кнопки изменения статуса после доставки заказа
        if (orders[orderIDD].status == OrderStatus.ord_delivered) {
            binding.statusButton.visibility = View.INVISIBLE
        }

        // Обработчик кнопки возврата к списку заказов
        binding.backPage.setOnClickListener(){
            val intent = Intent(this, OrderListActivity::class.java)
            startActivity(intent)
        }

        // Обработчик кнопки перехода на главную страницу
        binding.navButton.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Обработчик кнопки генерации QR-кода
        binding.generateQRButton.setOnClickListener(){
            val intent = Intent(this, QR::class.java)
            startActivity(intent)
        }

        // Обработчик кнопки изменения статуса заказа
        binding.statusButton.setOnClickListener(){
            when (orders[orderIDD].status) {
                OrderStatus.ord_await -> {
                    orders[orderIDD].status = OrderStatus.way_pickup_point
                    binding.statusButton.text = "Прибыл в пункт выдачи"
                }
                OrderStatus.way_pickup_point -> {
                    orders[orderIDD].status = OrderStatus.pickup_point
                    binding.statusButton.text = "Подтвердить получение заказа"
                }
                OrderStatus.pickup_point -> {
                    val intent = Intent(this, QR::class.java)
                    startActivity(intent)
                }
                OrderStatus.way_to_cliet -> {
                    orders[orderIDD].status = OrderStatus.on_place
                    binding.statusButton.text = "Подтвердить передачу заказа"
                }
                OrderStatus.on_place -> {
                    val intent = Intent(this, QR::class.java)
                    startActivity(intent)
                }
                OrderStatus.ord_delivered -> {
                    binding.statusButton.visibility = View.INVISIBLE
                }
                else -> {}
            }
        }
    }

    /**
     * Метод вызывается при возобновлении активности.
     */
    override fun onResume() {
        super.onResume()

        // Обновление текста на кнопке в соответствии со статусом заказа
        when (orders[orderIDD].status) {
            OrderStatus.ord_await -> {
                binding.statusButton.text = "Принять заказ"
            }
            OrderStatus.way_pickup_point -> {
                binding.statusButton.text = "Прибыл в пункт выдачи"
            }
            OrderStatus.pickup_point -> {
                binding.statusButton.text = "Подтвердить получение заказа"
            }
            OrderStatus.way_to_cliet -> {
                binding.statusButton.text = "Прибыл к клиенту"
            }
            OrderStatus.on_place -> {
                binding.statusButton.text = "Подтвердить передачу заказа"
            }
            OrderStatus.ord_delivered -> {
                binding.statusButton.visibility = View.INVISIBLE
            }
            else -> {}
        }
    }
}
