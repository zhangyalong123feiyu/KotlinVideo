package com.lenovo.kotlinvideo.utils

import android.content.Context
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions

@GlideModule
class GlideKt : AppGlideModule() {
    override fun applyOptions(context: Context, builder: GlideBuilder) {
        super.applyOptions(context, builder)
        var requestOptions = RequestOptions.bitmapTransform(RoundedCorners(20)).override(300, 300)
        builder.setDefaultRequestOptions(requestOptions)

    }

}
