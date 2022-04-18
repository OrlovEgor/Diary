package ru.orlovegor.diaryapp.utils

import org.threeten.bp.Instant

fun compareTimestampsDate(calendarTimestamp: Long, taskTimestamp: Long): Boolean {
    val formatter = org.threeten.bp.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")
        .withZone(
            org.threeten.bp.ZoneId.systemDefault()
        )

    return formatter.format(Instant.ofEpochMilli(calendarTimestamp))
        .equals(formatter.format(Instant.ofEpochMilli(taskTimestamp)))
}

fun compareTimestampsTimeStart(taskTimestamp: Long, currentTime: String): Boolean {
    val formatter = org.threeten.bp.format.DateTimeFormatter.ofPattern("HH:mm")
        .withZone(
            org.threeten.bp.ZoneId.systemDefault()
        )
    return formatter.format(Instant.ofEpochMilli(taskTimestamp)).equals(currentTime)
}
