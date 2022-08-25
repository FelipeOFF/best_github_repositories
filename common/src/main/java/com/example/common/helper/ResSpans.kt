package com.example.common.helper

import android.content.Context
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.core.content.ContextCompat

class ResSpans(val context: Context) : Iterable<Any> {
    private val spans = ArrayList<Any>()

    override fun iterator() = spans.iterator()

    fun size(@DimenRes id: Int) =
        spans.add(AbsoluteSizeSpan(context.resources.getDimension(id).toInt()))

    fun color(@ColorRes id: Int) =
        spans.add(ForegroundColorSpan(ContextCompat.getColor(context, id)))
}
