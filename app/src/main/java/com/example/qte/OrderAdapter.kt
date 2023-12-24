package com.example.qte

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.qte.databinding.OrderItemBinding

class OrderAdapter(private val listener: Listener): RecyclerView.Adapter<OrderAdapter.OrderHolder>() {
        class OrderHolder(item: View): RecyclerView.ViewHolder(item) {
        private val binding = OrderItemBinding.bind(item)
        @SuppressLint("ResourceAsColor")
        fun bind(order: Order, listener: Listener) = with(binding){
            pickupPointName.text = order.pickupPoint.name
            clientName.text = "Клиент: " + order.client.name
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
            itemView.setOnClickListener(){
                listener.onCLick(order)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.order_item, parent, false)

        return OrderHolder(view)
    }

    override fun getItemCount(): Int {
        return orders.size
    }

    override fun onBindViewHolder(holder: OrderHolder, position: Int) {
        holder.bind(orders[position], listener)
    }

    interface Listener {
        fun onCLick(order: Order) {

        }
    }
}