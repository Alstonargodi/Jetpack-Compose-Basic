package com.example.testing_calculator_app

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculatorApp(
    modifier: Modifier = Modifier
){
    var lengthInput by remember { mutableStateOf("") }
    var widthInput by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    var lenght = lengthInput.toDoubleOrNull() ?: 0.0
    val width = widthInput.toDoubleOrNull() ?: 0.0

    Box ( 
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ){
        Column {
            TextField(
                value = lengthInput, 
                onValueChange = { lengthInput = it},
                label = { Text(stringResource(id = R.string.enter_length))},
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )
        }
    }
}