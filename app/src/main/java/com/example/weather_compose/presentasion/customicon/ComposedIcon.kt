package com.example.weather_compose.presentasion.customicon

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import com.example.weather_compose.presentasion.customicon.iconutils.ComposeInfo
import com.example.weather_compose.presentasion.customicon.iconutils.IconInfo
import com.example.weather_compose.presentasion.customicon.iconutils.WeatherComposedInfo.IconSize
import com.example.weather_compose.presentasion.customicon.weathericon.AnimatableCloud
import com.example.weather_compose.presentasion.customicon.weathericon.AnimatableRains
import com.example.weather_compose.presentasion.customicon.weathericon.AnimatableSnow
import com.example.weather_compose.presentasion.customicon.weathericon.AnimatableSun
import com.example.weather_compose.presentasion.customicon.weathericon.AnimatableThunder

@Composable
fun ComposedIcon(
    modifier: Modifier = Modifier,
    composeInfo: ComposeInfo
){

    val (sun, cloud, lightCloud, rains, lightRain, snow, thunder) = composeInfo
    Box(modifier = modifier.size(IconSize)) {

        val _modifier = remember(Unit) {
            { icon: IconInfo ->
                Modifier
                    .offset(
                        icon.size * icon.offset.x,
                        icon.size * icon.offset.y
                    )
                    .size(icon.size * icon.sizeRatio)
                    .alpha(icon.alpha)
            }
        }

        AnimatableSun(_modifier(sun))

        AnimatableRains(_modifier(rains))

        AnimatableRains(_modifier(lightRain), true) // light rain

        AnimatableSnow(_modifier(snow))

        AnimatableCloud(_modifier(cloud))

        AnimatableCloud(_modifier(lightCloud), 1000) // light cloud

        AnimatableThunder(_modifier(thunder))
    }
}