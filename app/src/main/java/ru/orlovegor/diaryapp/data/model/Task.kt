package ru.orlovegor.diaryapp.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.sql.Timestamp

@JsonClass(generateAdapter = true)
data class Task(
    val id: Int,
    @Json(name = "date_start")
    val dateStart: Long,
    @Json(name = "date_finish")
    val dateFinish: Long,
    val name: String,
    val description: String
) {
}