package org.example.mixedwashdummy.util

import kotlinx.datetime.*
import kotlinx.datetime.TimeZone

object DateTimeUtils {
    fun formatTimestamp(timestamp: Long): String {
        val instant = Instant.fromEpochMilliseconds(timestamp)
        val dateTime = instant.toLocalDateTime(TimeZone.UTC) // Change to your desired timezone

        val monthAbbreviations = listOf(
            "Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
        )

        val day = dateTime.dayOfMonth
        val month = monthAbbreviations[dateTime.monthNumber - 1]

        val hour = if (dateTime.hour % 12 == 0) 12 else dateTime.hour % 12
        val minutes = dateTime.minute.toString().padStart(2, '0')
        val amPm = if (dateTime.hour < 12) "am" else "pm"

        return "$day $month • $hour:$minutes $amPm"
    }

}