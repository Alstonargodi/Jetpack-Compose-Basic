package com.dicoding.jetreward.ui

sealed class Screen(
    val route : String
){
    object Home: Screen("home")
    object Cart : Screen("cart")
    object Profile : Screen("Profile")
}

