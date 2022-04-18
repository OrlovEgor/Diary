package ru.orlovegor.diaryapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.orlovegor.diaryapp.data.model.TimeRangeTask
import ru.orlovegor.diaryapp.databinding.ItemTaskToTimeBinding

class TaskToTimeAdapter(private val onItemClick: (taskId: Long) -> Unit) :
    ListAdapter<TimeRangeTask, TaskToTimeAdapter.Holder>(TaskToTimeDiffer()) {

    class TaskToTimeDiffer : DiffUtil.ItemCallback<TimeRangeTask>() {
        override fun areItemsTheSame(oldItem: TimeRangeTask, newItem: TimeRangeTask): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TimeRangeTask, newItem: TimeRangeTask): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemTaskToTimeBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return Holder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }


    class Holder(
        private val binding: ItemTaskToTimeBinding,
        onItemClick: (taskId: Long) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(timeRangeTask: TimeRangeTask) {
            with(binding) {
                itemHoursStart.text = timeRangeTask.hoursStart
                itemHoursEnd.text = timeRangeTask.hoursEnd
                itemDescription.text = timeRangeTask.name

            }
        }
    }
}


