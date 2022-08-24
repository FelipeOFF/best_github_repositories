package com.example.common.helper

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("textInt")
fun TextView.textInt(value: Int?) {
    if (value != null && value != 0 && value != -1) {
        setText(value)
    }
}
