package com.example.common.helper

import android.view.View
import androidx.databinding.BindingAdapter
import com.google.android.material.appbar.MaterialToolbar

@BindingAdapter("navigationClickListener")
fun MaterialToolbar.setNavigationClickListener(listener: View.OnClickListener) {
    setNavigationOnClickListener(listener)
}