package com.gucodero.androidjetpack.ui.main.splash_screen.bindable_util.base

import android.content.Context
import android.text.SpannableStringBuilder
import com.gucodero.androidjetpack.ui.main.splash_screen.bindable_util.Text

abstract class BindableText: Linkable() {
    abstract fun buildText(context: Context): SpannableStringBuilder
    operator fun plus(value: BindableText): BindableText {
        last?.next = value
        return this
    }
    operator fun plus(value: String): BindableText {
        last?.next = Text(value)
        return this
    }
}