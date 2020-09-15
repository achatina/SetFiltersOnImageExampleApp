package com.shavrin.photosepia

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.esafirm.imagepicker.features.ImagePicker
import com.esafirm.imagepicker.model.Image
import com.shavrin.photosepia.filters.SepiaFilter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pick_image_button.setOnClickListener {
            openGallery()
        }

    }

    private fun openGallery() {
        ImagePicker
            .create(this)
            .showCamera(false)
            .theme(R.style.AppTheme)
            .single()
            .start()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (ImagePicker.shouldHandle(requestCode, resultCode, data)) {
            ImagePicker.getFirstImageOrNull(data)?.let { handleImage(it) }
        }
    }

    private fun handleImage(image: Image) {
        val progressBar = CircularProgressDrawable(this).apply {
            strokeWidth = 5f
            centerRadius = 30f
            start()
        }
        Glide.with(pick_image_content)
            .asBitmap()
            .load(image.uri)
            .transform(FilterGlideTransformation(SepiaFilter()))
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .placeholder(progressBar)
            .skipMemoryCache(true)
            .into(pick_image_content)
    }

}