package ru.surinov.demo.themes.lib

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

class NightModeProvider(context: Context) {

    companion object {
        private const val PREF_NAME = "night_mode_prefs"
        private const val PREF_KEY_NIGHT_MODE = "night_mode"
    }

    private val sharedPreferences = context.getSharedPreferences(
        PREF_NAME,
        AppCompatActivity.MODE_PRIVATE
    )

    fun saveNightMode(nightMode: AppNightMode) {
        sharedPreferences.edit()
            .putInt(PREF_KEY_NIGHT_MODE, nightMode.id)
            .apply()
    }

    fun getNightMode(): AppNightMode {
        val mode = sharedPreferences.getInt(PREF_KEY_NIGHT_MODE, AppNightMode.OFF.id)

        return when (mode) {
            AppNightMode.ON.id -> AppNightMode.ON
            AppNightMode.OFF.id -> AppNightMode.OFF
            else -> AppNightMode.FOLLOW_SYSTEM
        }
    }

}