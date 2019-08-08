package com.robertlevonyan.components.kex

import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import java.io.File
import java.io.InputStream

fun Uri.realPath(context: Context): Uri {
    val result: String
    val cursor = context.contentResolver.query(this, null, null, null, null)

    if (cursor == null) {
        result = this.path ?: return Uri.EMPTY
    } else {
        cursor.moveToFirst()
        val idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA)
        result = cursor.getString(idx)
        cursor.close()
    }
    return Uri.parse(result)
}

fun String.toUri(): Uri {
    return Uri.parse(this)
}

fun File.toUri(): Uri {
    return Uri.fromFile(this)
}

fun Uri.toFile(): File {
    return File(this.path ?: Uri.EMPTY.toString())
}

fun File.copyInputStreamToFile(inputStream: InputStream) {
    inputStream.use { input ->
        this.outputStream().use { fileOut ->
            input.copyTo(fileOut)
        }
    }
}