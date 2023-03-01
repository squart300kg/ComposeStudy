package com.codelabs.state.ui

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel: ViewModel() {

    val wellnessTasks = List(30) { i -> WellnessTask(i, "Task # $i")}

    private val _task = wellnessTasks.toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _task

    fun remove(item: WellnessTask) {
        _task.remove(item)
    }

    fun changeTaskChecked(item: WellnessTask, checked: Boolean) =
        tasks.find { it.id == item.id }?.let { task ->
            task.checked = checked
        }

}