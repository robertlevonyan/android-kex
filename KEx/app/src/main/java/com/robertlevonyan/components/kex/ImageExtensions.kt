package com.robertlevonyan.components.kex

import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.Icon
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.support.annotation.DrawableRes
import android.support.annotation.RequiresApi
import android.widget.ImageView
import java.io.ByteArrayOutputStream
import java.io.FileNotFoundException

infix fun Bitmap.rotate(degree: Int): Bitmap {
    val w = width
    val h = height

    val mtx = Matrix()
    mtx.postRotate(degree.toFloat())

    return Bitmap.createBitmap(this, 0, 0, w, h, mtx, true)
}

fun Bitmap.toUriJpeg(context: Context, title: String, description: String): Uri {
    val bytes = ByteArrayOutputStream()
    compress(Bitmap.CompressFormat.JPEG, 100, bytes)
    val path = MediaStore.Images.Media.insertImage(context.contentResolver, this, title, description)
    return Uri.parse(path)
}

fun Bitmap.toUriPng(context: Context, title: String, description: String): Uri {
    val bytes = ByteArrayOutputStream()
    compress(Bitmap.CompressFormat.PNG, 100, bytes)
    val path = MediaStore.Images.Media.insertImage(context.contentResolver, this, title, description)
    return Uri.parse(path)
}

fun Bitmap.toUriWebp(context: Context, title: String, description: String): Uri {
    val bytes = ByteArrayOutputStream()
    compress(Bitmap.CompressFormat.WEBP, 100, bytes)
    val path = MediaStore.Images.Media.insertImage(context.contentResolver, this, title, description)
    return Uri.parse(path)
}

fun Bitmap.makeCircle(): Bitmap? {
    val output = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(output)

    val color = -0xbdbdbe
    val paint = Paint()
    val rect = Rect(0, 0, width, height)

    paint.isAntiAlias = true
    canvas.drawARGB(0, 0, 0, 0)
    paint.color = color

    canvas.drawCircle(width.div(2f), height.div(2f), width.div(2f), paint)
    paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
    canvas.drawBitmap(this, rect, rect, paint)

    return output
}

fun Bitmap.toDrawable(context: Context): Drawable {
    return BitmapDrawable(context.resources, this)
}

fun Drawable.toBitmap(): Bitmap? {
    val bitmap: Bitmap? = if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
        Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888)
    } else {
        Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888)
    }

    if (this is BitmapDrawable) {
        if (this.bitmap != null) {
            return this.bitmap
        }
    }

    val canvas = Canvas(bitmap)
    setBounds(0, 0, canvas.width, canvas.height)
    draw(canvas)

    return bitmap
}

@Throws(FileNotFoundException::class)
fun Uri.toBitmap(context: Context): Bitmap {
    return MediaStore.Images.Media.getBitmap(context.contentResolver, this)
}

@Throws(FileNotFoundException::class)
fun Uri.toDrawable(context: Context): Drawable {
    val inputStream = context.contentResolver.openInputStream(this)
    return Drawable.createFromStream(inputStream, this.toString())
}

infix fun ImageView.set(@DrawableRes id: Int) {
    setImageResource(id)
}

infix fun ImageView.set(bitmap: Bitmap) {
    setImageBitmap(bitmap)
}

infix fun ImageView.set(drawable: Drawable) {
    setImageDrawable(drawable)
}

@RequiresApi(Build.VERSION_CODES.M)
infix fun ImageView.set(ic: Icon) {
    setImageIcon(ic)
}

infix fun ImageView.set(uri: Uri) {
    setImageURI(uri)
}