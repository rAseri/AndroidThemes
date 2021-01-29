package ru.surinov.demo.themes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.surinov.demo.themes.lib.ThemeDemoFragment

class ThemeOverrideDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_override_demo)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, ThemeDemoFragment.newInstance(R.style.CustomTheme))
            .commit()
    }

}