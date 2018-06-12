package com.robertlevonyan.components.kex

import android.content.Context
import android.support.annotation.StringRes
import android.text.Editable
import android.text.Spannable
import android.text.SpannableString
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView


fun EditText.focus() {
    if (hasFocus()) {
        setSelection(text.length)
    }
}

fun EditText.afterTextChanged(afterTextChanged: (Editable?) -> Unit) {
    addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            afterTextChanged(s)
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

    })
}

fun EditText.beforeTextChanged(beforeTextChanged: (CharSequence?, Int, Int, Int) -> Unit) {
    addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            beforeTextChanged(s, start, count, after)
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

    })
}

fun EditText.onTextChanged(onTextChanged: (CharSequence?, Int, Int, Int) -> Unit) {
    addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            onTextChanged(s, start, before, count)
        }

    })
}


fun EditText.requestFocusAndKeyboard() {
    requestFocus()
    val imm: InputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE)
            as InputMethodManager
    imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}

fun EditText.clearFocusAndKeyboard() {
    clearFocus()
    val imm: InputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE)
            as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

infix fun TextView.set(@StringRes id: Int) {
    setText(id)
}

infix fun TextView.set(text: String) {
    setText(text)
}

infix fun TextView.set(text: Spannable) {
    setText(text)
}