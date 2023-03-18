package com.dicoding.jetreward.ui.screen

import androidx.compose.ui.graphics.vector.ImageVector
import com.dicoding.jetreward.ui.Screen

data class NavigationItem(
    val title : String,
    val icon : ImageVector,
    val screen: Screen
)
