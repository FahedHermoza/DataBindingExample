package com.gucodero.androidjetpack.ui.main.splash_screen.bindable_util.extensions

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