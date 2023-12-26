package com.example.qte


import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityCompat
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKit
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView

@Suppress("DEPRECATION")
/**
 * Главная активность приложения.
 */
class MainActivity : ComponentActivity() {
    // Инициализация переменных для элементов пользовательского интерфейса
    private lateinit var mapView: MapView
    private lateinit var pickupPointTitle: TextView
    private lateinit var pickupPointAddressTitle: TextView
    private lateinit var clientAddressTitle: TextView
    private lateinit var changeStatus: Button
    private lateinit var orderInfo: CardView

    /**
     * Метод вызывается при создании активности.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Инициализация MapKit и установка API-ключа
        MapKitFactory.setApiKey("cb379ab9-c564-41ca-bd72-3e4e63a2a243")
        MapKitFactory.initialize(this)

        // Установка макета для страницы (activity)
        setContentView(R.layout.mapview)

        // Настройка карты и позиции камеры
        mapView = findViewById(R.id.mapView)
        mapView.map.move(
            CameraPosition(Point(56.850001, 53.205517), 13.0f, 8.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 3f),
            null
        )

        val mapKit: MapKit = MapKitFactory.getInstance()
        requestLocationPermission()
        val locationonmapkit = mapKit.createUserLocationLayer(mapView.mapWindow)
        locationonmapkit.isVisible = true

        // Инициализация переменных для элементов пользовательского интерфейса
        pickupPointTitle = findViewById(R.id.pickupPointTitle)
        pickupPointAddressTitle = findViewById(R.id.pickupPointAddressTitle)
        clientAddressTitle = findViewById(R.id.clientAddressTitle)
        changeStatus = findViewById(R.id.changeStatus)
        orderInfo = findViewById(R.id.orderInfo)

        // Обработчик нажатия на кнопку изменения статуса заказа и надписи на кнопке в зависимости от статуса заказа
        changeStatus.setOnClickListener {
            when (orders[orderIDD].status) {
                OrderStatus.ord_await -> {
                    orders[orderIDD].status = OrderStatus.way_pickup_point
                    changeStatus.text = "Прибыл в пункт выдачи"
                }
                OrderStatus.way_pickup_point -> {
                    orders[orderIDD].status = OrderStatus.pickup_point
                    changeStatus.text = "Подтвердить получение заказа"
                }
                OrderStatus.pickup_point -> {
                    val intent = Intent(this, QR::class.java)
                    startActivity(intent)
                    changeStatus.text = "Прибыл к клиенту"
                }
                OrderStatus.way_to_cliet -> {
                    orders[orderIDD].status = OrderStatus.on_place
                    changeStatus.text = "Подтвердить передачу заказа"
                }
                OrderStatus.on_place -> {
                    val intent = Intent(this, QR::class.java)
                    startActivity(intent)
                    orderInfo.visibility = View.INVISIBLE
                    changeStatus.text = "Выбрать следующий заказ"
                }
                OrderStatus.ord_delivered -> {
                    val intent = Intent(this, OrderListActivity::class.java)
                    startActivity(intent)
                }
                else -> {}
            }
        }
    }

    // Метод для перехода к странице профиля
    fun toProfile(view: View) {
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
    }

    // Метод для перехода к странице списка заказов
    fun toOrderList(view: View) {
        val intent = Intent(this, OrderListActivity::class.java)
        startActivity(intent)
    }

    // Метод для запроса разрешения на использование местоположения
    private fun requestLocationPermission() {
        if ((ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED) &&
            (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED)
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ),
                1
            )
            return
        }
    }

    // Метод, вызываемый при возобновлении активности
    override fun onResume() {
        super.onResume()

        // Обновление данных о заказе выводимых на экран
        pickupPointTitle.text = orders[orderIDD].pickupPoint.name
        pickupPointAddressTitle.text = orders[orderIDD].pickupPoint.address
        clientAddressTitle.text = orders[orderIDD].client.address
        orderInfo.visibility = View.VISIBLE

        when (orders[orderIDD].status) {
            OrderStatus.ord_await -> {
                changeStatus.text = "Приянть заказ"
            }
            OrderStatus.way_pickup_point -> {
                changeStatus.text = "Прибыл в пункт выдачи"
            }
            OrderStatus.pickup_point -> {
                changeStatus.text = "Подтвердить получение заказа"
            }
            OrderStatus.way_to_cliet -> {
                changeStatus.text = "Прибыл к клиенту"
            }
            OrderStatus.on_place -> {
                changeStatus.text = "Подтвердить передачу заказа"
            }
            OrderStatus.ord_delivered -> {
                changeStatus.visibility = View.INVISIBLE
            }
            else -> {}
        }
    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        mapView.onStart()
    }

    override fun onStop() {
        mapView.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }
}

