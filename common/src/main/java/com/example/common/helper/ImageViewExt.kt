package com.example.common.helper

import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

@BindingAdapter(value = ["urlload", "imageErrorResource", "progressBar"], requireAll = true)
fun ImageView.loadImage(url: String, imageErrorResource: Drawable, progressBar: ProgressBar) {
    progressBar.show()
    Glide.with(context)
        .load(url)
        .error(imageErrorResource)
        .listener(
            object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean,
                ): Boolean {
                    progressBar.hide()
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean,
                ): Boolean {
                    progressBar.hide()
                    return false
                }
            }
        ).into(this)
}
