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
        val lastName = intent.getStringExtra(EXTRA_TEXT_LASTNAME)
        aboutText?.text = "Над программой работали: $lastName"

    }


    private fun initializeViews() {
        aboutText = findViewById(R.id.text_view_about_activity_about)
    }

    companion object {
        const val EXTRA_TEXT_LASTNAME = "lastName"
    }

}