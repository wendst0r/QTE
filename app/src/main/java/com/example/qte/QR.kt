package com.example.qte

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.qte.databinding.ActivityQrBinding

/**
 * Класс, представляющий активность для отображения QR-кода и выполнения дополнительных действий.
 */
class QR : AppCompatActivity() {

    // Инициализация привязки для макета
    private lateinit var binding: ActivityQrBinding

    /**
     * Метод, вызываемый при создании активности.
     *
     * @param savedInstanceState Состояние активности, сохраненное при предыдущих запусках.
     */
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Инициализация привязки
        binding = ActivityQrBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Установка названия пункта выдачи в элемент пользовательского интерфейса
        binding.orderNameTitle.text = orders[orderIDD].pickupPoint.name

        // Обработчик нажатия на кнопку
        binding.imageButton.setOnClickListener() {
            val intent = Intent(applicationContext, OrderInformationActivity::class.java)
            // Переход на страницу с информацией о заказе
            startActivity(intent)
        }

        // Обработчик нажатия на изображение
        binding.imageView.setOnClickListener() {
            // Создание интента для перехода к активности с информацией о заказе
            when (orders[orderIDD].status) {
                OrderStatus.pickup_point -> {
                    orders[orderIDD].status = OrderStatus.way_to_cliet
                    binding.cardView9.setCardBackgroundColor(R.color.order_active)
                    val intent = Intent(applicationContext, OrderInformationActivity::class.java)
                    // Переход на страницу с информацией о заказе
                    startActivity(intent)
                }
                OrderStatus.on_place -> {
                    orders[orderIDD].status = OrderStatus.ord_delivered
                    binding.cardView9.setCardBackgroundColor(R.color.order_active)
                    val intent = Intent(applicationContext, OrderInformationActivity::class.java)
                    // Переход на страницу с информацией о заказе
                    startActivity(intent)
                }
                else -> {}
            }
        }
    }
}
