package com.shavrin.photosepia

import android.graphics.Bitmap
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import com.shavrin.photosepia.filters.FilterDrawer
import com.shavrin.photosepia.filters.ImageFilter
import java.security.MessageDigest

class FilterGlideTransformation(
    private val filter: ImageFilter
) : BitmapTransformation() {

    override fun updateDiskCacheKey(messageDigest: MessageDigest) {
        //do not cache images for applying different filter transformations
    }

    override fun transform(
        pool: BitmapPool,
        toTransform: Bitmap,
        outWidth: Int,
        outHeight: Int
    ): Bitmap {
        return FilterDrawer.drawBitmap(toTransform, filter)
    }
}