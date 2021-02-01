package ru.surinov.demo.themes.lib

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_theme_demo.*

class ThemeToggleDemoActivity : AppCompatActivity() {

    private lateinit var themeSettingRepository: ThemeSettingRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        themeSettingRepository = ThemeSettingRepository(this)
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
        return themeSettingRepository.getAppTheme()
    }

    private fun toggleAppTheme() {
        val currentAppTheme = getCurrentAppTheme()

        val newAppTheme = if (currentAppTheme == AppTheme.LIGHT) {
            AppTheme.DARK
        } else {
            AppTheme.LIGHT
        }

        themeSettingRepository.saveAppTheme(newAppTheme)
        AppCompatDelegate.setDefaultNightMode(newAppTheme.nightMode)
    }

}