package com.robertlevonyan.components.kex

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.support.annotation.*
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.view.View
import android.view.WindowManager

fun Fragment.color(@ColorRes clr: Int): Int {
    return context!!.color(clr)
}

fun Fragment.string(@StringRes str: Int): String {
    return getString(str)
}

fun Fragment.drawable(@DrawableRes drw: Int): Drawable? {
    return context!!.drawable(drw)
}

fun Fragment.dimen(@DimenRes dmn: Int): Float {
    return context!!.dimen(dmn)
}

fun Fragment.dimenInt(@DimenRes dmn: Int): Int {
    return context!!.dimenInt(dmn)
}

fun Fragment.int(@IntegerRes int: Int): Int {
    return context!!.int(int)
}

fun Fragment.font(@FontRes font: Int): Typeface? {
    return context!!.font(font)
}

fun Fragment.stringArray(array: Int): Array<String> {
    return context!!.stringArray(array)
}

fun Fragment.intArray(array: Int): IntArray {
    return context!!.intArray(array)
}

fun FragmentActivity.replaceFragment(fragment: Fragment, @IdRes container: Int,
                                     addToBackStack: Boolean = false, backStackName: String = "",
                                     @AnimRes inAnimationRes: Int = 0, @AnimRes outAnimationRes: Int = 0) {
    val ft = supportFragmentManager.beginTransaction()
    if (inAnimationRes != 0 && outAnimationRes != 0) {
        ft.setCustomAnimations(inAnimationRes, outAnimationRes)
    }
    ft.replace(container, fragment)

    if (addToBackStack) {
        ft.addToBackStack(backStackName)
    }

    ft.commit()
}

fun FragmentActivity.replaceFragmentWithAnimation(fragment: Fragment, @IdRes container: Int,
                                                  addToBackStack: Boolean = false, backStackName: String = "",
                                                  @AnimRes inAnimationRes: Int, @AnimRes outAnimationRes: Int) {
    val ft = supportFragmentManager.beginTransaction()
    ft.setCustomAnimations(inAnimationRes, outAnimationRes)
    ft.replace(container, fragment)

    if (addToBackStack) {
        ft.addToBackStack(backStackName)
    }

    ft.commit()
}

fun FragmentActivity.addFragment(fragment: Fragment, @IdRes container: Int,
                                 addToBackStack: Boolean = false, backStackName: String = "",
                                 @AnimRes inAnimationRes: Int = 0, @AnimRes outAnimationRes: Int = 0) {
    val ft = supportFragmentManager.beginTransaction()
    if (inAnimationRes != 0 && outAnimationRes != 0) {
        ft.setCustomAnimations(inAnimationRes, outAnimationRes)
    }
    ft.add(container, fragment)

    if (addToBackStack) {
        ft.addToBackStack(backStackName)
    }

    ft.commit()
}

fun <T> Activity.startActivity(activityTo: Class<T>, extras: Bundle = Bundle(),
                               overrideTransitions: Boolean = false,
                               enterAnim: Int = 0, exitAnim: Int = 0) {
    val starter = Intent(this, activityTo)
    if (!extras.isEmpty) {
        starter.putExtras(extras)
    }
    startActivity(starter)
    if (overrideTransitions) {
        overridePendingTransition(enterAnim, exitAnim)
    }
}

fun <T> Activity.startActivityForResult(activityTo: Class<T>, requestCode: Int,
                                        extras: Bundle = Bundle(), overrideTransitions: Boolean = false,
                                        enterAnim: Int = 0, exitAnim: Int = 0) {
    val starter = Intent(this, activityTo)
    if (!extras.isEmpty) {
        starter.putExtras(extras)
    }
    startActivityForResult(starter, requestCode)
    if (overrideTransitions) {
        overridePendingTransition(enterAnim, exitAnim)
    }
}

fun <T> Fragment.startActivityForResult(activityTo: Class<T>, requestCode: Int,
                                        extras: Bundle = Bundle(), overrideTransitions: Boolean = false,
                                        enterAnim: Int = 0, exitAnim: Int = 0) {
    val starter = Intent(activity, activityTo)
    if (!extras.isEmpty) {
        starter.putExtras(extras)
    }
    startActivityForResult(starter, requestCode)
    if (overrideTransitions) {
        activity!!.overridePendingTransition(enterAnim, exitAnim)
    }
}

fun <T> Activity.startActivityWithTransitions(activityTo: Class<T>, extras: Bundle, options: Bundle = Bundle()) {
    val starter = Intent(this, activityTo)
    if (!extras.isEmpty) {
        starter.putExtras(extras)
    }
    ActivityCompat.startActivity(this, starter, options)
}

fun <T> Activity.startActivityForResultWithTransitions(activityTo: Class<T>, requestCode: Int,
                                                       extras: Bundle = Bundle(), options: Bundle) {
    val starter = Intent(this, activityTo)
    if (!extras.isEmpty) {
        starter.putExtras(extras)
    }
    ActivityCompat.startActivityForResult(this, starter, requestCode, options)
}

@RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
fun <T> Activity.startActivityFromFragmentWithTransitions(fragmentFrom: android.app.Fragment, activityTo: Class<T>,
                                                          requestCode: Int = 0, extras: Bundle = Bundle(), options: Bundle) {
    val starter = Intent(this, activityTo)
    if (!extras.isEmpty) {
        starter.putExtras(extras)
    }
    startActivityFromFragment(fragmentFrom, starter, requestCode, options)
}

fun <T> Activity.startActivityFromFragmentWithResult(activityTo: Class<T>, fragmentFrom: android.app.Fragment, requestCode: Int = 0, extras: Bundle = Bundle()) {
    val starter = Intent(this, activityTo)
    if (!extras.isEmpty) {
        starter.putExtras(extras)
    }

    startActivityFromFragment(fragmentFrom, starter, requestCode)
}

fun <T> Fragment.startActivityFromFragmentWithResult(activityTo: Class<T>, requestCode: Int = 0, extras: Bundle = Bundle()) {
    val starter = Intent(activity, activityTo)
    if (!extras.isEmpty) {
        starter.putExtras(extras)
    }

    activity!!.startActivityFromFragment(this, starter, requestCode)
}

@RequiresApi(Build.VERSION_CODES.KITKAT)
fun Activity.makeTranslucentStatusBar() {
    window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
}

@RequiresApi(Build.VERSION_CODES.KITKAT)
fun Activity.makeNormalStatusBar(statusBarColor: Int = -1) {
    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
    window.decorView.rootView.systemUiVisibility = 0
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        window.statusBarColor = if (statusBarColor == -1) Color.BLACK else statusBarColor
    }
}

@RequiresApi(Build.VERSION_CODES.KITKAT)
fun Activity.makeTranslucentNavigationBar() {
    window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
}

@RequiresApi(Build.VERSION_CODES.KITKAT)
fun Activity.makeNormalNavigationBar(navigationBarColor: Int = -1) {
    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
    window.decorView.rootView.systemUiVisibility = 0
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        window.navigationBarColor = if (navigationBarColor == -1) Color.BLACK else navigationBarColor
    }
}

@RequiresApi(Build.VERSION_CODES.M)
fun Activity.lightStatusBar(statusBarColor: Int = -1) {
    when (window.decorView.rootView.systemUiVisibility) {
        0 -> window.decorView.rootView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                window.decorView.rootView.systemUiVisibility =
                        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR + View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
            } else {
                window.decorView.rootView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
        }
    }
    window.statusBarColor = if (statusBarColor == -1) Color.WHITE else statusBarColor
}

@RequiresApi(Build.VERSION_CODES.O)
fun Activity.lightNavigation(navigationBarColor: Int = -1) {
    when (window.decorView.rootView.systemUiVisibility) {
        0 -> window.decorView.rootView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR -> {
            window.decorView.rootView.systemUiVisibility =
                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR + View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
        }
    }
    window.navigationBarColor = if (navigationBarColor == -1) Color.WHITE else navigationBarColor
}