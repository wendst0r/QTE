package com.example.qte

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.qte.databinding.ActivityOrderListBinding

/**
 * Активность для отображения списка заказов.
 */
class OrderListActivity : ComponentActivity(), OrderAdapter.Listener {

    // Инициализация привязки для макета
    private lateinit var binding: ActivityOrderListBinding
    // Создание адаптера для списка заказов
    private val adapter = OrderAdapter(this)

    /**
     * Метод, вызываемый при создании активности.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Инициализация привязки
        binding = ActivityOrderListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Инициализация RecyclerView
        init()
    }

    /**
     * Метод для инициализации RecyclerView.
     */
    private fun init() = with(binding) {
        rcView.layoutManager = LinearLayoutManager(this@OrderListActivity)
        rcView.adapter = adapter
    }

    /**
     * Обработчик нажатия на элемент списка заказов.
     *
     * @param order Выбранный заказ.
     */
    override fun onCLick(order: Order) {
        // Создание интента для перехода к активности с информацией о заказе
        val intent = Intent(applicationContext, OrderInformationActivity::class.java)

        // Сохранение ID текущего активного заказа
        orderIDD = order.orderId

        // Переход на страницу с информацией о заказе
        startActivity(intent)
    }

    /**
     * Метод вызывается при возобновлении активности.
     */
    override fun onResume() {
        super.onResume()
        // Можно добавить дополнительные действия при возобновлении активности
    }
}

