package com.gucodero.androidjetpack.ui.main.splash_screen.bindable_util.extensions

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.gucodero.androidjetpack.ui.main.splash_screen.bindable_util.Text
import com.gucodero.androidjetpack.ui.main.splash_screen.bindable_util.base.BindableText

fun Number.toFormatString(decimals: Int? = null, separator: String = "."): String{
    return if (decimals != null){
        "%.${decimals}f".format(toDouble()).replace(",",separator)
    }else{
        toString()
    }
}

fun String.toText(): BindableText = Text(this)

@BindingAdapter("bindableText")
fun setTextBuilder(view: TextView, bindableText: BindableText?){
    view.text = bindableText?.buildText(view.context)
}