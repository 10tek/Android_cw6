package kz.step.cw6

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView

class CameraActivity : AppCompatActivity() {
    private val REQUEST_TAKE_PHOTO = 1
    lateinit var photoImageView: ImageView
    var captureButton: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
        initializeViews()
        initializeListeners()
    }

    private fun initializeViews() {
        captureButton = findViewById(R.id.button_camera_activity_capture)
        photoImageView = findViewById(R.id.image_view_camera_activity_photo)
    }


    private fun initializeListeners() {
        captureButton?.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            try {
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO)
            } catch (e: ActivityNotFoundException) {
                e.printStackTrace()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
            // Фотка сделана, извлекаем миниатюру картинки
            val thumbnailBitmap = data?.extras?.get("data") as Bitmap
            photoImageView.setImageBitmap(thumbnailBitmap)
        }

    }
}