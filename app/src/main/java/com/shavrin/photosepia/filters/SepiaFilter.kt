package com.shavrin.photosepia.filters

import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.graphics.drawable.Drawable

class SepiaFilter : ImageFilter {

    override fun setColorFilter(drawable: Drawable): Drawable {
        val matrixA = ColorMatrix()
        // making image B&W
        matrixA.setSaturation(0f)
        val matrixB = ColorMatrix()
        // applying scales for RGB color values
        matrixB.setScale(1f, .9f, .72f, 1.0f)
        matrixA.setConcat(matrixB, matrixA)
        val filter = ColorMatrixColorFilter(matrixA)
        drawable.colorFilter = filter
        return drawable
    }

}