package com.helium4.mindtek.Utils

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.helium4.mindtek.R

class IndicatorView(context: Context, attrs: AttributeSet? = null) : ConstraintLayout(context, attrs) {

    init {
        LayoutInflater.from(context).inflate(R.layout.indicator_view, this, true)
    }

    fun setNumIndicators(numIndicators: Int) {
        for (i in 0 until numIndicators) {
            val indicator = ImageView(context)
            indicator.setImageResource(R.drawable.indicator)
            val params = LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
            )
            params.marginStart = 8
            indicator.layoutParams = params
            addView(indicator)
        }
    }
    fun setActiveIndicator(position: Int) {
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            if (child is ImageView) {
                val indicator = child as ImageView
                indicator.setImageResource(if (i == position) R.drawable.selected else R.drawable.indicator)
            }
        }
    }
}
