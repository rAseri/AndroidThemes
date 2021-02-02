package ru.surinov.demo.themes.lib

import androidx.appcompat.app.AppCompatDelegate

enum class AppNightMode(
    val mode: Int,
    val id: Int
) {
    ON(
        mode = AppCompatDelegate.MODE_NIGHT_YES,
        id = 0
    ),
    OFF(
        mode = AppCompatDelegate.MODE_NIGHT_NO,
        id = 1
    ),
    FOLLOW_SYSTEM(
        mode = AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM,
        id = 2
    )
}