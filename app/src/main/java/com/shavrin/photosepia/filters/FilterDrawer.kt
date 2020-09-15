package com.shavrin.photosepia.filters

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable

object FilterDrawer {

    fun drawBitmap(src: Bitmap, filter: ImageFilter): Bitmap {
        return filter.setColorFilter(src.toDrawable()).toBitmap()
    }

    fun drawDrawable(src: Drawable, filter: ImageFilter): Bitmap {
        return filter.setColorFilter(src).toBitmap()
    }

    fun Drawable.toBitmap(): Bitmap {
        val bitmap: Bitmap =
            Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        setBounds(0, 0, canvas.width, canvas.height)
        draw(canvas)
        return bitmap
    }

    fun Bitmap.toDrawable(): Drawable {
        return BitmapDrawable(null, this)
    }
}