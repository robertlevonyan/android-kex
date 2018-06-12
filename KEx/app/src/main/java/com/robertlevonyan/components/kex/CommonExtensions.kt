package com.robertlevonyan.components.kex

import android.support.design.widget.BottomSheetBehavior
import android.view.View

fun BottomSheetBehavior<View>.onSlide(onSlide: (View, Float) -> Unit) {
    setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
        override fun onSlide(bottomSheet: View, slideOffset: Float) {
            onSlide(bottomSheet, slideOffset)
        }

        override fun onStateChanged(bottomSheet: View, newState: Int) {
        }

    })
}

fun BottomSheetBehavior<View>.onStateChanged(onStateChanged: (View, Int) -> Unit) {
    setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
        override fun onSlide(bottomSheet: View, slideOffset: Float) {
        }

        override fun onStateChanged(bottomSheet: View, newState: Int) {
            onStateChanged(bottomSheet, newState)
        }

    })
}