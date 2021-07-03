package com.gucodero.androidjetpack.ui.main.splash_screen.models

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.gucodero.androidjetpack.BR
import com.gucodero.androidjetpack.ui.components.binding.BannerUIEntity

class SplashScreenUIEntity(
    count: Int? = null,
    color: Int? = null,
    bannerList: List<BannerUIEntity>? = null
): BaseObservable() {

    @Bindable
    var count: Int? = count
        set(value) {
            field = value
            notifyPropertyChanged(BR.count)
        }

    @Bindable
    var color: Int? = color
        set(value) {
            field = value
            notifyPropertyChanged(BR.color)
        }

    @Bindable
    var bannerList: List<BannerUIEntity>? = bannerList
        set(value) {
            field = value
            notifyPropertyChanged(BR.bannerList)
        }

}