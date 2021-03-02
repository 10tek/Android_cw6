package kz.step.cw6

import android.content.Intent
import android.nfc.NfcAdapter.EXTRA_DATA
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {
    var aboutButton: Button? = null
    var cameraButton: Button? = null
    private val lastName = "Oralbayev"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()
        initializeListeners()
    }

    private fun initializeViews() {
        aboutButton = findViewById(R.id.button_main_activity_about)
        cameraButton = findViewById(R.id.button_main_activity_camera)
    }

    private fun initializeListeners() {
        aboutButton?.setOnClickListener {
            val intent = Intent(this@MainActivity, AboutActivity::class.java)

            // в ключ lastName пихаем текст из второго текстового поля
            intent.putExtra(AboutActivity.EXTRA_TEXT_LASTNAME, lastName)
            startActivity(intent)
        }

        cameraButton?.setOnClickListener {
            val intent = Intent(this@MainActivity, CameraActivity::class.java)
            startActivity(intent)
        }
    }
}