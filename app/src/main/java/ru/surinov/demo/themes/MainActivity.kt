package ru.surinov.demo.themes

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*
import ru.surinov.demo.themes.lib.NightModeProvider
import ru.surinov.demo.themes.lib.ThemeSettingDemoActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.LibTheme)
        applySavedNightMode()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startThemeSettingDemoButton.setOnClickListener {
            val intent = Intent(this, ThemeSettingDemoActivity::class.java)
            startActivity(intent)
        }

        startThemeOverrideDemoButton.setOnClickListener {
            val intent = Intent(this, ThemeOverrideDemoActivity::class.java)
            startActivity(intent)
        }
    }

    private fun applySavedNightMode() {
        val nightModeManager = NightModeProvider(this)
        val nightMode = nightModeManager.getNightMode()
        AppCompatDelegate.setDefaultNightMode(nightMode.mode)
    }

}