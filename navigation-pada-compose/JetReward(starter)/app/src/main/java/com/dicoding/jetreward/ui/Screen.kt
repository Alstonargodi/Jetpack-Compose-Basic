package com.dicoding.jetreward.ui

sealed class Screen(
    val route : String
){
    object Home: Screen("home")
    object Cart : Screen("cart")
    object Profile : Screen("Profile")
    object DetailReward : Screen("home/{rewardId}"){
        fun createRoute(rewardId : Long) = "home/$rewardId"
    }
}

