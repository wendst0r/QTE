package com.example.qte

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.qte.databinding.ActivityOrderListBinding

class OrderListActivity : AppCompatActivity(), OrderAdapter.Listener {

    private lateinit var binding: ActivityOrderListBinding
    private val adapter = OrderAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOrderListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()


    }

    private fun init() = with(binding) {
        rcView.layoutManager = LinearLayoutManager(this@OrderListActivity)
        rcView.adapter = adapter
    }

    override fun onCLick(order: Order) {
        val intent = Intent(applicationContext, OrderInformationActivity::class.java)
        orderIDD = order.orderId
        startActivity(intent)
    }
}
