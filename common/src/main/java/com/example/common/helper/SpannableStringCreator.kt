package com.example.common.helper

import android.text.SpannableString
import android.text.Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
import android.text.TextUtils.concat

class SpannableStringCreator {

    private val parts = ArrayList<CharSequence>()
    private var length = 0
    private val spanMap: MutableMap<IntRange, Iterable<Any>> = HashMap()

    fun appendSpace(newText: CharSequence) = append(" ").append(newText)

    fun append(newText: CharSequence, spans: Iterable<Any>) = apply {
        val end = newText.length
        parts.add(newText)
        spanMap[(length..length + end)] = spans
        length += end
    }

    fun append(newText: CharSequence) = apply {
        parts.add(newText)
        length += newText.length
    }

    inline fun applyIf(predicate: () -> Boolean, action: SpannableStringCreator.() -> SpannableStringCreator) =
        if (predicate()) action() else this

    @Suppress("SpreadOperator")
    fun toSpannableString() = SpannableString(concat(*parts.toTypedArray())).apply {
        spanMap.forEach {
            val range = it.key
            it.value.forEach { span ->
                setSpan(span, range.first, range.last, SPAN_EXCLUSIVE_EXCLUSIVE)
            }
        }
    }
}
