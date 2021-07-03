package com.gucodero.androidjetpack.ui.components

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.gucodero.androidjetpack.databinding.LayoutBannerBinding

class Banner @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val inflater = LayoutInflater.from(context)

    private val binding = LayoutBannerBinding.inflate(inflater, this, true)

    var radius: Float? = null
        set(value) {
            field = value
            field?.let {
                binding.card.radius = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, it, resources.displayMetrics)
            }
        }

    var text: String? = null
        set(value) {
            field = value
            binding.text.text = field
        }

    var borderWidth: Float? = null
        set(value){
            field = value
            field?.let {
                binding.card.strokeWidth = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, it, resources.displayMetrics).toInt()
            }
        }

    var borderColor: Int? = null
        set(value) {
            field = value
            field?.let {
                binding.card.strokeColor = ContextCompat.getColor(context, it)
            }
        }

}