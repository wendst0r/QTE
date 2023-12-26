package com.example.qte

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.qte.databinding.OrderItemBinding

// Адаптер для отображения списка заказов
/**
 * Адаптер для RecyclerView, предназначенный для отображения списка заказов.
 *
 * @property listener Слушатель событий для обработки нажатия на элемент списка.
 */
class OrderAdapter(private val listener: Listener): RecyclerView.Adapter<OrderAdapter.OrderHolder>() {

    /**
     * ViewHolder для элемента заказа в RecyclerView.
     *
     * @param item View, представляющее элемент списка заказов.
     */
    class OrderHolder(item: View): RecyclerView.ViewHolder(item) {
        private val binding = OrderItemBinding.bind(item)

        /**
         * Метод для привязки данных заказа к элементам макета.
         *
         * @param order Заказ для отображения.
         * @param listener Слушатель событий для обработки нажатия на элемент списка.
         */
        @SuppressLint("ResourceAsColor")
        fun bind(order: Order, listener: Listener) = with(binding){
            pickupPointName.text = order.pickupPoint.name
            clientName.text = "Клиент: " + order.client.name

            // Определение видимости элементов в зависимости от статуса заказа
            when (order.status){
                OrderStatus.ord_await -> {
                    Active.visibility = View.INVISIBLE
                    Delivered.visibility = View.INVISIBLE
                    Await.visibility = View.VISIBLE
                }
                OrderStatus.ord_delivered -> {
                    Active.visibility = View.INVISIBLE
                    Delivered.visibility = View.VISIBLE
                    Await.visibility = View.INVISIBLE
                }
                else -> {
                    Active.visibility = View.VISIBLE
                    Delivered.visibility = View.INVISIBLE
                    Await.visibility = View.INVISIBLE
                }
            }

            // Обработчик нажатия на элемент списка
            itemView.setOnClickListener(){
                listener.onCLick(order)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.order_item, parent, false)
        return OrderHolder(view)
    }

    // Получение общего количества элементов в списке для корректного отображения RecyclerView
    override fun getItemCount(): Int {
        return orders.size
    }

    override fun onBindViewHolder(holder: OrderHolder, position: Int) {
        holder.bind(orders[position], listener)
    }

    /**
     * Интерфейс слушателя событий для обработки нажатия на элемент списка заказов.
     */
    interface Listener {
        /**
         * Вызывается при нажатии на элемент списка заказов.
         *
         * @param order Выбранный заказ.
         */
        fun onCLick(order: Order) {

        }
    }
}
