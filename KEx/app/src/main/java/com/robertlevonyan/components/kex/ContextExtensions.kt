package com.robertlevonyan.components.kex

import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import androidx.annotation.*
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import android.widget.Toast

fun Context.color(@ColorRes clr: Int): Int {
    return ContextCompat.getColor(this, clr)
}

fun Context.string(@StringRes str: Int): String {
    return getString(str)
}

fun Context.drawable(@DrawableRes drw: Int): Drawable? {
    return ContextCompat.getDrawable(this, drw)
}

fun Context.drawable(name: String, packageName: String): Drawable? {
    val drwId = resources.getIdentifier(name, "drawable", packageName)
    return ContextCompat.getDrawable(this, drwId)
}

fun Context.dimen(@DimenRes dmn: Int): Float {
    return resources.getDimension(dmn)
}

fun Context.dimenInt(@DimenRes dmn: Int): Int {
    return resources.getDimensionPixelSize(dmn)
}

fun Context.int(@IntegerRes int: Int): Int {
    return resources.getInteger(int)
}

fun Context.font(@FontRes font: Int): Typeface? {
    return ResourcesCompat.getFont(this, font)
}

fun Context.stringArray(array: Int): Array<String> {
    return resources.getStringArray(array)
}

fun Context.intArray(array: Int): IntArray {
    return resources.getIntArray(array)
}

fun Context.toast(message: Int, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}