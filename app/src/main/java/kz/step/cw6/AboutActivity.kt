package kz.step.cw6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class AboutActivity : AppCompatActivity() {
    var aboutText: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        initializeViews()
        initializeListeners()
    }


    private fun initializeViews() {
        aboutText = findViewById(R.id.text_view_about_activity_about)
    }

    private fun initializeListeners() {
        aboutText?.setOnClickListener {

        }

    }
}