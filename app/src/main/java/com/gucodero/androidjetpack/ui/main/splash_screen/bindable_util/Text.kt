package com.gucodero.androidjetpack.ui.main.splash_screen.bindable_util

import android.content.Context
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.gucodero.androidjetpack.ui.main.splash_screen.bindable_util.base.BindableText
import com.gucodero.androidjetpack.ui.main.splash_screen.bindable_util.extensions.toFormatString

data class Text(
    val str: String,
    val color: Int? = null,
    val colorRes: Int? = null,
    val bold: Boolean? = null
): BindableText(){

    constructor(
        number: Number,
        decimals: Int? = null,
        separator: String = ".",
        @ColorRes colorRes: Int? = null,
        color: Int? = null,
        bold: Boolean? = null
    ): this(
        str = number.toFormatString(decimals, separator),
        color = color,
        colorRes = colorRes,
        bold = bold
    )

    override fun buildText(context: Context): SpannableStringBuilder {
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