package ru.surinov.demo.themes.lib

import android.os.Bundle
import androidx.annotation.StyleRes
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_theme_demo.*

class ThemeToggleDemoActivity : AppCompatActivity() {

    enum class AppTheme(
        @StyleRes
        val themeRes: Int,
        val id: Int
    ) {
        LIGHT(R.style.LightTheme, 0),
        DARK(R.style.DarkTheme, 1)
    }

    companion object {
        private const val PREF_NAME = "theme_prefs"
        private const val PREF_THEME_KEY = "theme_key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(getCurrentAppTheme().themeRes)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_demo)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, ThemeDemoFragment())
            .commit()

        btnToggleTheme.setOnClickListener {
            toggleAppTheme()
        }
    }

    private fun getCurrentAppTheme(): AppTheme {
        val sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE)
        val themeId = sharedPreferences.getInt(PREF_THEME_KEY, AppTheme.LIGHT.id)

        return if (themeId == AppTheme.DARK.id) {
            AppTheme.DARK
        } else {
            AppTheme.LIGHT
        }
    }

    private fun toggleAppTheme() {
        val currentAppTheme = getCurrentAppTheme()

        val newAppTheme = if (currentAppTheme == AppTheme.LIGHT) {
            AppTheme.DARK
        } else {
            AppTheme.LIGHT
        }

        getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit()
            .putInt(PREF_THEME_KEY, newAppTheme.id)
            .apply()

        recreate()
    }

}