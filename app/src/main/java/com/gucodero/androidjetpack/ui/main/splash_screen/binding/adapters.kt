package com.gucodero.androidjetpack.ui.main.splash_screen.binding

import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.gucodero.androidjetpack.databinding.BindLayoutBannerBinding
import com.gucodero.androidjetpack.ui.components.binding.BannerUIEntity
import com.gucodero.androidjetpack.ui.main.splash_screen.bindable_util.base.BindableText

@BindingAdapter("colorBackground")
fun setColor(view: Button, value: Int?){
    value?.let {
        view.setBackgroundColor(ContextCompat.getColor(view.context, value))
    }
}

@BindingAdapter("bannerList")
fun setBannerList(view: LinearLayout, values: List<BannerUIEntity>?){
    view.removeAllViews()
    val inflater = LayoutInflater.from(view.context)
    values?.forEach {
        val binding = BindLayoutBannerBinding.inflate(inflater, view, false)
        binding.data = it
        view.addView(binding.root)
    }
}

@BindingAdapter("bindableText")
fun setTextBuilder(view: TextView, bindableText: BindableText?){
    view.text = bindableText?.buildText(view.context)
}