package com.gucodero.androidjetpack.ui.main.splash_screen.bindable_util

import android.content.Context
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import com.gucodero.androidjetpack.ui.main.splash_screen.bindable_util.base.BindableText

class TextRes(
    @StringRes val id: Int,
    vararg val args: Any,
): BindableText() {
    private var color: Int? = null
    private var colorRes: Int? = null
    private var bold: Boolean? = null

    fun modify(color: Int? = null, colorRes: Int? = null, bold: Boolean? = null){
        this.color = color
        this.colorRes = colorRes
        this.bold = bold
    }

    override fun buildText(context: Context): SpannableStringBuilder {
        val str = context.getString(id, *args)
        return SpannableStringBuilder(str).apply {
            color?.let {
                setSpan(ForegroundColorSpan(it), 0, str.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
            colorRes?.let {
                setSpan(ForegroundColorSpan(ContextCompat.getColor(context, it)), 0, str.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
            if(bold == true){
                setSpan(StyleSpan(Typeface.BOLD), 0, str.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
            next?.let { next ->
                if(next is BindableText){
                    append(next.buildText(context))
                }
            }
        }
    }

}