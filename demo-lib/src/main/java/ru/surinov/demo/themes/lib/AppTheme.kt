package ru.surinov.demo.themes.lib

import androidx.annotation.StyleRes
import androidx.appcompat.app.AppCompatDelegate

enum class AppTheme(
    @StyleRes
    val themeRes: Int,
    val nightMode: Int,
    val id: Int
) {
    LIGHT(
        themeRes = R.style.LightTheme,
        nightMode = AppCompatDelegate.MODE_NIGHT_NO,
        id = 0
    ),
    DARK(
        themeRes = R.style.DarkTheme,
        nightMode = AppCompatDelegate.MODE_NIGHT_YES,
        id = 1
    )
}