package com.example.weather_compose.presentasion.home

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.weather_compose.R
import com.example.weather_compose.presentasion.navigation.NavigationDestination
import com.example.weather_compose.presentasion.utils.ErrorScreen
import com.example.weather_compose.presentasion.utils.LoadingScreen
import com.example.weather_compose.remote.utils.FetchResult

object HomeDestination : NavigationDestination {
    override val route = "home"
    override val titleRes = R.string.app_name
}

@Composable
fun HomeActivity(
    fetchResult: FetchResult,
    modifier: Modifier = Modifier,
    onTryAgain: () -> Unit,
){
    when(fetchResult){
        is FetchResult.Loading ->{
            LoadingScreen()
        }
        is FetchResult.Success<*> ->{

        }
        is FetchResult.Error->{
            ErrorScreen(
                fetchResult.error,
                onTryAgain
            )
            Log.d("HomeActivity",fetchResult.error)
        }
    }
}