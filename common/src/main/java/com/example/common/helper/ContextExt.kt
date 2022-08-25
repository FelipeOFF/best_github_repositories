package com.example.common.helper

import android.content.Context

fun Context.resSpans(options: ResSpans.() -> Unit) =
    ResSpans(this).apply(options)