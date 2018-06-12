package com.robertlevonyan.components.kex

import android.graphics.PorterDuff
import android.view.View
import android.widget.CompoundButton
import android.widget.ProgressBar

fun ProgressBar.loaderColor(color: Int) {
    this.indeterminateDrawable.setColorFilter(color, PorterDuff.Mode.SRC_IN)
}

fun CompoundButton.onChecked(onChecked: (View, Boolean) -> Unit) {
    setOnCheckedChangeListener { buttonView, isChecked ->
        onChecked(buttonView, isChecked)
    }
}