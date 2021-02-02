package ru.surinov.demo.themes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.surinov.demo.themes.lib.ThemeDemoFragment

class ThemeOverrideDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_override_demo)

        if (savedInstanceState == null) {
            val demoFragment = ThemeDemoFragment.newInstance(R.style.CustomTheme)

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, demoFragment)
                .commit()
        }
    }

}