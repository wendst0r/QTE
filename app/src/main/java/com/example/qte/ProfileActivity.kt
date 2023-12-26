package com.example.qte

import android.os.Bundle
import androidx.activity.ComponentActivity

/**
 * Класс, представляющий активность профиля пользователя.
 */
class ProfileActivity : ComponentActivity() {
    /**
     * Метод, вызываемый при создании активности.
     *
     * @param savedInstanceState Состояние активности, сохраненное при предыдущих запусках.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Вызов метода родительского класса для корректной инициализации активности
        setContentView(R.layout.activity_profile) // Установка макета для активности
    }
}
