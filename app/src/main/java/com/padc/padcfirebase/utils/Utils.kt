package com.padc.padcfirebase.utils

import android.text.format.DateUtils

fun getPostedAgoTimeWithTimeStamp(timeStamp: String): String {
    val long = if (timeStamp.length == 10) (timeStamp.toLongOrNull() ?: 0) * 1000
    else timeStamp.toLongOrNull() ?: 0

    return if (DateUtils.getRelativeTimeSpanString(long).toString() == "0 minutes ago") "Just now"
    else DateUtils.getRelativeTimeSpanString(long).toString()
}

fun formatPhoneNumberWith959(number: String): String {
    return when {
        number.startsWith("959") -> number
        number.startsWith("09") -> "959" + number.substring(2, number.length)
        else -> "959$number"
    }
}