package com.example.statecompose.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.statecompose.WaterCounter
import com.example.statecompose.components.welltask.WellViewModel
import com.example.statecompose.model.WellnessTask

@Composable
fun WellScreen(
    modifier: Modifier = Modifier,
    wellsViewModel: WellViewModel = viewModel()
){
    Column(modifier = modifier){
        WaterCounter()
        WellTaskList(
            list = wellsViewModel.tasks,
            onCloseTask = { task ->
                wellsViewModel.remove(task)
            },
            onCheckedTask = { task,check->
                wellsViewModel.changeTaskChecked(task,check)
            }
        )
    }
}
