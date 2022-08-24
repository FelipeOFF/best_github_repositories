package com.example.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

fun ViewGroup.inflateBinding(layoutRes: Int): ViewDataBinding =
    DataBindingUtil.inflate(LayoutInflater.from(context), layoutRes, this, false)
