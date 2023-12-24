package com.example.qte

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.qte.databinding.ActivityOrderInformationBinding

@Suppress("DEPRECATION")
class OrderInformationActivity: AppCompatActivity() {
    private lateinit var binding: ActivityOrderInformationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_information)

        binding = ActivityOrderInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val item = intent.getSerializableExtra("item") as Order
        binding.apply{
            orderTitle.text = item.pickupPoint.name
            deliveryTime.text = item.deliveryTime
            pickupPointAddress.text = item.pickupPoint.address
            clientAddress.text = item.client.address
            flat.text = item.client.flatNum
            floorNum.text = item.client.floorNum.toString()
            entrance.text = item.client.entranceNum.toString()
            content.text = item.content
            clientNameTitle.text = item.client.name
            comment.text = item.client.comment
        }
    }
}