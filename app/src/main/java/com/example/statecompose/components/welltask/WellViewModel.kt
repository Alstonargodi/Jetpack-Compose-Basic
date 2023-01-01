package com.example.statecompose.components.welltask

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.statecompose.model.WellnessTask

class WellViewModel: ViewModel() {
    private val task = getWellnessTask().toMutableStateList()
    val tasks: List<WellnessTask>
    get() = task

    fun remove(item: WellnessTask){
        task.remove(item)
    }

    fun changeTaskChecked(item: WellnessTask,checked : Boolean) =
        task.find { it.id == item.id }?.let { task ->
            task.checked = checked
        }
}


//data source
private fun getWellnessTask() = List(30){ i->
    WellnessTask(
        i,
        "task $i"
    )
}