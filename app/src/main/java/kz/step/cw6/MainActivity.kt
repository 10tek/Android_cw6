package kz.step.cw6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {
    var aboutButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()
        initializeLiseners()
    }

    private fun initializeViews() {
        aboutButton = findViewById(R.id.button_main_activity_about)
    }

    private fun initializeLiseners() {
        aboutButton?.setOnClickListener {
            val intent = Intent(this@MainActivity, AboutActivity::class.java)
            startActivity(intent)
        }

    }
}