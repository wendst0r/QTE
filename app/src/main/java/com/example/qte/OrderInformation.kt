package com.example.qte

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.qte.databinding.ActivityOrderInformationBinding

class OrderInformationActivity: AppCompatActivity()  {
    private lateinit var binding: ActivityOrderInformationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_information)

        binding = ActivityOrderInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //val item = intent.getIntExtra("item") as? Order
        binding.apply{
            orderTitle.text = orders[orderIDD].pickupPoint.name
            deliveryTime.text = orders[orderIDD].deliveryTime
            pickupPointAddress.text = orders[orderIDD].pickupPoint.address
            clientAddress.text = orders[orderIDD].client.address
            flat.text = orders[orderIDD].client.flatNum
            floorNum.text = orders[orderIDD].client.floorNum.toString()
            entrance.text = orders[orderIDD].client.entranceNum.toString()
            content.text = orders[orderIDD].content
            clientNameTitle.text = orders[orderIDD].client.name
            comment.text = orders[orderIDD].client.comment
        }
    }
}