package com.gucodero.androidjetpack.ui.main.splash_screen.bindable_util

import android.content.Context
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ImageSpan
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.gucodero.androidjetpack.ui.main.splash_screen.bindable_util.base.BindableText

data class IconRes(
    @DrawableRes val id: Int,
    @ColorRes val colorRes: Int? = null,
    val color: Int? = null
): BindableText() {

    override fun buildText(context: Context): SpannableStringBuilder {
        val drawable = ContextCompat.getDrawable(context, id) ?: return SpannableStringBuilder("")
        drawable.setBounds(0, 0,  drawable.intrinsicWidth, drawable.intrinsicHeight)
        return SpannableStringBuilder(" ").apply {
            if (color != null) {
                DrawableCompat.setTint(drawable, color)
            }
            if (colorRes != null) {
                DrawableCompat.setTint(drawable, ContextCompat.getColor(context, colorRes))
            }
            setSpan(ImageSpan(drawable), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            next?.let { next ->
                if(next is BindableText){
                    append(next.buildText(context))
                }
            }
        }
    }
}