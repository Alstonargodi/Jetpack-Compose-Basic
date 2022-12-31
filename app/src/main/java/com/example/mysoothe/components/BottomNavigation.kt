package com.example.mysoothe.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun BottomNavigationHome(
    modifier: Modifier = Modifier
){
    BottomNavigation(
        backgroundColor = Color(0x32a856),
        modifier = modifier
    ) {
        BottomNavigationItem(
            icon = {
                   Icon(
                       imageVector = Icons.Default.Star ,
                       contentDescription = null
                   )
            },
            label = {
                    Text(text = "navitem")
            },
            selected =true,
            onClick = {}
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Star ,
                    contentDescription = null
                )
            },
            label = {
                Text(text = "navitem")
            },
            selected =true,
            onClick = {}
        )
    }
}