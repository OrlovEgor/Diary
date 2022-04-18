package ru.orlovegor.diaryapp.data.model

data class TimeRangeTask(
    val id: Int,
    val hoursStart: String,
    val hoursEnd: String,
    var name: String
)
