package ru.surinov.demo.themes.lib

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

class ThemeSettingRepository(context: Context) {

    companion object {
        private const val PREF_NAME = "theme_prefs"
        private const val PREF_THEME_KEY = "theme_key"
    }

    private val sharedPreferences = context.getSharedPreferences(
        PREF_NAME,
        AppCompatActivity.MODE_PRIVATE
    )

    fun getAppTheme(): AppTheme {
        val themeId = sharedPreferences.getInt(PREF_THEME_KEY, AppTheme.LIGHT.id)

        return if (themeId == AppTheme.DARK.id) {
            AppTheme.DARK
        } else {
            AppTheme.LIGHT
        }
    }

    fun saveAppTheme(theme: AppTheme) {
        sharedPreferences.edit()
            .putInt(PREF_THEME_KEY, theme.id)
            .apply()
    }

}