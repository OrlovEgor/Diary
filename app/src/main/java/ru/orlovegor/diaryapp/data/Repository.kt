package ru.orlovegor.diaryapp.data

import com.squareup.moshi.Moshi
import ru.orlovegor.diaryapp.data.model.Task
import ru.orlovegor.diaryapp.data.model.TimeRangeTask
import ru.orlovegor.diaryapp.utils.compareTimestampsDate
import ru.orlovegor.diaryapp.utils.compareTimestampsTimeStart

class Repository(val moshi: Moshi) {


    //TODO запилить di moshi

    /*suspend fun parseTasks(jsonTasks: String) =
        withContext(Dispatchers.IO) {
            val type = Types.newParameterizedType(List::class.java, Task::class.java)
            val adapter: JsonAdapter<List<Task>> = moshi.adapter(type)
            //TODO обернуть в трай кэтч и кидать исключения если нул то нет чего тотам или какая нибудт еще кинуть нпе в мождели поймать и отобразить стэйт какой нибудь
            val tasks = adapter.fromJson(jsonTasks)
            tasks ?: listOf()
        }*/


    fun goGo(
        calendarTimestamp: Long,
        jsonTasks: ArrayList<Task>
    ): ArrayList<TimeRangeTask> {
        val timeRangeTasks = listToTime
        jsonTasks.forEach { jsonTask ->
            if (compareTimestampsDate(calendarTimestamp, jsonTask.dateStart)) {
                timeRangeTasks.forEach { timeTask ->
                    if (compareTimestampsTimeStart(jsonTask.dateStart, timeTask.hoursStart)) {
                        timeTask.name = jsonTask.name
                    }
                }
            }
        }
        return timeRangeTasks
    }

    val listToTime = arrayListOf<TimeRangeTask>(
        TimeRangeTask(0, "00:00", "01:00", ""),
        TimeRangeTask(1, "01:00", "02:00", ""),
        TimeRangeTask(2, "02:00", "03:00", ""),
        TimeRangeTask(3, "03:00", "04:00", ""),
        TimeRangeTask(4, "04:00", "05:00", ""),
        TimeRangeTask(5, "05:00", "06:00", ""),
        TimeRangeTask(6, "06:00", "07:00", ""),
        TimeRangeTask(7, "07:00", "08:00", ""),
        TimeRangeTask(8, "08:00", "09:00", ""),
        TimeRangeTask(9, "09:00", "10:00", ""),
        TimeRangeTask(10, "10:00", "11:00", ""),
        TimeRangeTask(11, "11:00", "12:00", ""),
        TimeRangeTask(12, "12:00", "13:00", ""),
        TimeRangeTask(13, "13:00", "14:00", ""),
        TimeRangeTask(14, "14:00", "15:00", ""),
        TimeRangeTask(15, "15:00", "16:00", ""),
        TimeRangeTask(16, "16:00", "17:00", ""),
        TimeRangeTask(17, "17:00", "18:00", ""),
        TimeRangeTask(18, "18:00", "19:00", ""),
        TimeRangeTask(19, "19:00", "20:00", ""),
        TimeRangeTask(20, "20:00", "21:00", ""),
        TimeRangeTask(21, "21:00", "22:00", ""),
        TimeRangeTask(22, "22:00", "23:00", ""),
        TimeRangeTask(23, "23:00", "00:00", "")
    )
}
