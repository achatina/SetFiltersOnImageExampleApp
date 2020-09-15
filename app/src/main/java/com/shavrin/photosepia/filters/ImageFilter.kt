package com.shavrin.photosepia.filters

import android.graphics.Bitmap
import android.graphics.drawable.Drawable

interface ImageFilter {

    fun setColorFilter(drawable: Drawable): Drawable

}