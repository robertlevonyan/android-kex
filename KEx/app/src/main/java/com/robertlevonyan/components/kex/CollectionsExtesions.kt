package com.robertlevonyan.components.kex

import java.util.*

fun <T> List<T>.randomItem(): T {
    return this[Random().nextInt(size)]
}