package com.robertlevonyan.components.kex

import java.util.*

fun Calendar.getDayOfWeek(date: Date): Int {
    val c = Calendar.getInstance()
    c.time = date
    return c.get(Calendar.DAY_OF_WEEK)
}

fun Calendar.getDayOfWeek(): Int {
    return getDayOfWeek(Date())
}

fun Calendar.getDayOfMonth(date: Date): Int {
    val c = Calendar.getInstance()
    c.time = date
    return c.get(Calendar.DAY_OF_MONTH)
}

fun Calendar.getDayOfMonth(): Int {
    return getDayOfMonth(Date())
}

fun Calendar.getDayOfWeekInMonth(date: Date): Int {
    val c = Calendar.getInstance()
    c.time = date
    return c.get(Calendar.DAY_OF_WEEK_IN_MONTH)
}

fun Calendar.getDayOfWeekInMonth(): Int {
    return getDayOfWeekInMonth(Date())
}

fun Calendar.getYear(date: Date): Int {
    val c = Calendar.getInstance()
    c.time = date
    return c.get(Calendar.YEAR)
}

fun Calendar.getYear(): Int {
    return getYear(Date())
}

fun Calendar.getDayOfYear(date: Date): Int {
    val c = Calendar.getInstance()
    c.time = date
    return c.get(Calendar.DAY_OF_YEAR)
}

fun Calendar.getDayOfYear(): Int {
    return getYear(Date())
}

fun Calendar.getWeekOfYear(date: Date): Int {
    val c = Calendar.getInstance()
    c.time = date
    return c.get(Calendar.WEEK_OF_YEAR)
}

fun Calendar.getWeekOfYear(): Int {
    return getYear(Date())
}

fun Calendar.getWeekOfMonth(date: Date): Int {
    val c = Calendar.getInstance()
    c.time = date
    return c.get(Calendar.WEEK_OF_MONTH)
}

fun Calendar.getWeekOfMonth(): Int {
    return getYear(Date())
}

fun Calendar.getHourOfDay(date: Date): Int {
    val c = Calendar.getInstance()
    c.time = date
    return c.get(Calendar.HOUR_OF_DAY)
}

fun Calendar.getHourOfDay(): Int {
    return getYear(Date())
}

fun Calendar.getHour(date: Date): Int {
    val c = Calendar.getInstance()
    c.time = date
    return c.get(Calendar.HOUR)
}

fun Calendar.getHour(): Int {
    return getYear(Date())
}

fun Calendar.getMinute(date: Date): Int {
    val c = Calendar.getInstance()
    c.time = date
    return c.get(Calendar.MINUTE)
}

fun Calendar.getMinute(): Int {
    return getYear(Date())
}

fun Calendar.getSecond(date: Date): Int {
    val c = Calendar.getInstance()
    c.time = date
    return c.get(Calendar.SECOND)
}

fun Calendar.getSecond(): Int {
    return getYear(Date())
}

fun Calendar.getMillisecond(date: Date): Int {
    val c = Calendar.getInstance()
    c.time = date
    return c.get(Calendar.MILLISECOND)
}

fun Calendar.getMillisecond(): Int {
    return getYear(Date())
}