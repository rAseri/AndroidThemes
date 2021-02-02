package ru.surinov.demo.themes.lib

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_theme_demo.*

class ThemeSettingDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.LibTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_demo)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, ThemeDemoFragment())
                .commit()
        }

        btnTurnDarkMode.setOnClickListener {
            updateNightMode(nightMode = AppNightMode.ON)
        }

        btnTurnLightMode.setOnClickListener {
            updateNightMode(nightMode = AppNightMode.OFF)
        }

        btnTurnFollowSystemMode.setOnClickListener {
            updateNightMode(nightMode = AppNightMode.FOLLOW_SYSTEM)
        }
    }

    private fun updateNightMode(nightMode: AppNightMode) {
        val nightModeProvider = NightModeProvider(this)
        nightModeProvider.saveNightMode(nightMode)
        AppCompatDelegate.setDefaultNightMode(nightMode.mode)
    }

}