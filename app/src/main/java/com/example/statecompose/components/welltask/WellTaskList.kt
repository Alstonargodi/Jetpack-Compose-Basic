package com.example.statecompose.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.statecompose.model.WellnessTask

@Composable
fun WellTaskList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask>,
    onCloseTask: (WellnessTask)-> Unit,
    onCheckedTask: (WellnessTask,Boolean) -> Unit
){
    LazyColumn(modifier = modifier){
        items(
            items = list,
            key = { task ->
                task.id
            }
        ){ task->
            WellTaskItem(
                task = task.label,
                onClose = {
                    onCloseTask(task)
                },
                checked = task.checked,
                onCheckedChange = {
                    checked -> onCheckedTask(task,checked)
                }
            )
        }
    }
}

