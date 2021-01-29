package ru.surinov.demo.themes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import ru.surinov.demo.themes.lib.ThemeToggleDemoActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startThemeToggleDemoButton.setOnClickListener {
            val intent = Intent(this, ThemeToggleDemoActivity::class.java)
            startActivity(intent)
        }

        startThemeOverrideDemoButton.setOnClickListener {
            val intent = Intent(this, ThemeOverrideDemoActivity::class.java)
            startActivity(intent)
        }
    }

}