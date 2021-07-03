package com.gucodero.androidjetpack.ui.components.binding

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.gucodero.androidjetpack.BR

class BannerUIEntity(
    radius: Float? = null,
    text: String? = null,
    borderWidth: Float? = null,
    borderColor: Int? = null
): BaseObservable() {

    @Bindable
    var radius: Float? = radius
        set(value) {
            field = value
            notifyPropertyChanged(BR.radius)
        }

    @Bindable
    var text: String? = text
        set(value) {
            field = value
            notifyPropertyChanged(BR.text)
        }

    @Bindable
    var borderWidth: Float? = borderWidth
        set(value) {
            field = value
            notifyPropertyChanged(BR.borderWidth)
        }

    @Bindable
    var borderColor: Int? = borderColor
        set(value) {
            field = value
            notifyPropertyChanged(BR.borderColor)
        }

}