package com.example.weather_compose.presentasion.customicon.iconutils
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weather_compose.presentasion.customicon.iconutils.WeatherAnimatableIcon.CloudyAnimatableIcon
import com.example.weather_compose.presentasion.customicon.iconutils.WeatherAnimatableIcon.HeavyRainAnimatableIcon
import com.example.weather_compose.presentasion.customicon.iconutils.WeatherAnimatableIcon.MostlyClearAnimatableIcon
import com.example.weather_compose.presentasion.customicon.iconutils.WeatherAnimatableIcon.RainAnimatableIcon
import com.example.weather_compose.presentasion.customicon.iconutils.WeatherAnimatableIcon.SnowAnimatableIcon
import com.example.weather_compose.presentasion.customicon.iconutils.WeatherAnimatableIcon.SunnyAnimatableIcon
import com.example.weather_compose.presentasion.customicon.iconutils.WeatherAnimatableIcon.ThunderStormAnimatableIcon
import com.example.weather_compose.presentasion.customicon.iconutils.WeatherBackground.ClearBg
import com.example.weather_compose.presentasion.customicon.iconutils.WeatherBackground.CloudyBg
import com.example.weather_compose.presentasion.customicon.iconutils.WeatherBackground.RainBg
import com.example.weather_compose.presentasion.customicon.iconutils.WeatherBackground.ShowersBg
import com.example.weather_compose.presentasion.customicon.iconutils.WeatherBackground.SnowBg
import com.example.weather_compose.presentasion.customicon.iconutils.WeatherBackground.StormBg
import com.example.weather_compose.presentasion.customicon.iconutils.WeatherBackground.SunnyBg
import com.example.weather_compose.presentasion.customicon.iconutils.WeatherComposedInfo.CloudyComposed
import com.example.weather_compose.presentasion.customicon.iconutils.WeatherComposedInfo.CloudyRainComposed
import com.example.weather_compose.presentasion.customicon.iconutils.WeatherComposedInfo.HeavyRainComposed
import com.example.weather_compose.presentasion.customicon.iconutils.WeatherComposedInfo.MostlyClearComposed
import com.example.weather_compose.presentasion.customicon.iconutils.WeatherComposedInfo.SnowyComposed
import com.example.weather_compose.presentasion.customicon.iconutils.WeatherComposedInfo.SunnyComposed
import com.example.weather_compose.presentasion.customicon.iconutils.WeatherComposedInfo.ThunderStormComposed
import com.example.weather_compose.presentasion.customicon.iconutils.WeatherIcon.CloudyIcon
import com.example.weather_compose.presentasion.customicon.iconutils.WeatherIcon.HeavyRainIcon
import com.example.weather_compose.presentasion.customicon.iconutils.WeatherIcon.MostlyClearIcon
import com.example.weather_compose.presentasion.customicon.iconutils.WeatherIcon.RainIcon
import com.example.weather_compose.presentasion.customicon.iconutils.WeatherIcon.SnowyIcon
import com.example.weather_compose.presentasion.customicon.iconutils.WeatherIcon.SunnyIcon
import com.example.weather_compose.presentasion.customicon.iconutils.WeatherIcon.ThunderStormIcon
import com.example.weather_compose.presentasion.customicon.weathericon.AnimatableCloud
import com.example.weather_compose.presentasion.customicon.weathericon.AnimatableRains
import com.example.weather_compose.presentasion.customicon.weathericon.AnimatableSnow
import com.example.weather_compose.presentasion.customicon.weathericon.AnimatableSun
import com.example.weather_compose.presentasion.customicon.weathericon.AnimatableThunder
import com.example.weather_compose.presentasion.customicon.weathericon.Cloud
import com.example.weather_compose.presentasion.customicon.weathericon.Rains
import com.example.weather_compose.presentasion.customicon.weathericon.Snow
import com.example.weather_compose.presentasion.customicon.weathericon.Sun
import com.example.weather_compose.presentasion.customicon.weathericon.Thunder
import com.example.weather_compose.ui.theme.teal500
import com.example.weather_compose.ui.theme.teal700
import com.example.weather_compose.ui.theme.teal900
import com.example.weather_compose.ui.theme.yellow200
import com.example.weather_compose.ui.theme.yellow500


enum class Weather(
    val text: String = "",
    val composedIcon: ComposeInfo,
    val icon: @Composable () -> Unit,
    val animatableIcon: @Composable () -> Unit,
    val background: BgColors
) {
    Sunny(
        "Sunny",
        SunnyComposed, SunnyIcon, SunnyAnimatableIcon, SunnyBg
    ),
    MostlyClear(
        "Clear with periodic clouds",
        MostlyClearComposed, MostlyClearIcon, MostlyClearAnimatableIcon, ClearBg
    ),

    Cloudy(
        "Cloudy",
        CloudyComposed, CloudyIcon, CloudyAnimatableIcon, CloudyBg
    ),

    CloudyRain(
        "Cloudy with periodic showers",
        CloudyRainComposed, RainIcon, RainAnimatableIcon, ShowersBg
    ),

    HeavyRain(
        "Heavy rain",
        HeavyRainComposed, HeavyRainIcon, HeavyRainAnimatableIcon, RainBg
    ),

    Snowy(
        "Snowy",
        SnowyComposed, SnowyIcon, SnowAnimatableIcon, SnowBg
    ),

    Storm(
        "Thundery storm",
        ThunderStormComposed, ThunderStormIcon, ThunderStormAnimatableIcon, StormBg
    )
}

/**
 * background color for each type of weather
 */
typealias BgColors = Triple<Color, Color, Color>

object WeatherBackground {

    val ShowersBg = BgColors(
        teal700,
        Color.LightGray,
        teal900
    )

    val RainBg = BgColors(
        Color.LightGray,
        Color.Gray,
        Color.White
    )

    val CloudyBg = BgColors(
        teal700,
        teal500,
        Color.White
    )

    val SunnyBg = BgColors(
        yellow200,
        teal500,
        yellow500
    )

    val ClearBg = BgColors(
        teal500,
        teal900,
        teal500
    )

    val SnowBg = BgColors(
        Color.LightGray,
        Color.White,
        teal700
    )

    val StormBg = BgColors(
        Color.Black,
        Color.White,
        Color.DarkGray
    )
}

/**
 * used in central area
 */
object WeatherComposedInfo {

    val IconSize = 200.dp // ComposedIcon size

    val SunnyComposed = ComposeInfo(
        sun = IconInfo(1f),
        cloud = IconInfo(0.8f, Offset(-0.1f, 0.1f), 0f),
        lightCloud = IconInfo(0.5f, Offset(-0.15f, 0.35f), 0f),
        rains = IconInfo(0.4f, Offset(0.225f, 0.3f), 0f),
        lightRain = IconInfo(0.4f, Offset(0.225f, 0.3f), 0f),
        snow = IconInfo(0.5f, Offset(0.1f, 0.3f), alpha = 0f),
        thunder = IconInfo(0.45f, Offset(0.29f, 0.6f), alpha = 0f)

    )

    val MostlyClearComposed = ComposeInfo(
        sun = IconInfo(0.85f, Offset(0.1f, 0f)),
        cloud = IconInfo(0.5f, Offset(-0.1f, 0.1f), 0f),
        lightCloud = IconInfo(0.4f, Offset(0.175f, 0.375f), 1f),
        rains = IconInfo(0.4f, Offset(0.225f, 0.3f), 0f),
        lightRain = IconInfo(0.4f, Offset(0.225f, 0.3f), 0f),
        snow = IconInfo(0.5f, Offset(0.1f, 0.3f), alpha = 0f),
        thunder = IconInfo(0.45f, Offset(0.29f, 0.6f), alpha = 0f)

    )

    val CloudyComposed = ComposeInfo(
        sun = IconInfo(0.1f, Offset(0.75f, 0.2f), alpha = 0f),
        cloud = IconInfo(0.8f, Offset(0.1f, 0.1f)),
        lightCloud = IconInfo(0.5f, Offset(0.05f, 0.125f)),
        rains = IconInfo(0.4f, Offset(0.225f, 0.3f), alpha = 0f),
        lightRain = IconInfo(0.4f, Offset(0.225f, 0.3f), alpha = 0f),
        snow = IconInfo(0.5f, Offset(0.1f, 0.3f), alpha = 0f),
        thunder = IconInfo(0.45f, Offset(0.29f, 0.6f), alpha = 0f)

    )

    val CloudyRainComposed = ComposeInfo(
        sun = IconInfo(0.6f, Offset(0.4f, 0f)),
        cloud = IconInfo(0.8f, Offset(0.1f, 0.1f)),
        lightCloud = IconInfo(0.5f, Offset(-0.15f, 0.125f), 0f),
        rains = IconInfo(0.4f, Offset(0.225f, 0.3f), 0f),
        lightRain = IconInfo(0.4f, Offset(0.225f, 0.3f), 1f),
        snow = IconInfo(0.5f, Offset(0.1f, 0.3f), alpha = 0f),
        thunder = IconInfo(0.45f, Offset(0.29f, 0.6f), alpha = 0f)

    )

    val HeavyRainComposed = ComposeInfo(
        sun = IconInfo(0.1f, Offset(0.75f, 0.2f), alpha = 0f),
        cloud = IconInfo(0.8f, Offset(0.1f, 0.1f)),
        lightCloud = IconInfo(0.5f, Offset(0.05f, 0.125f)),
        rains = IconInfo(0.4f, Offset(0.225f, 0.3f), alpha = 1f),
        lightRain = IconInfo(0.4f, Offset(0.225f, 0.3f), 0f),
        snow = IconInfo(0.5f, Offset(0.1f, 0.3f), alpha = 0f),
        thunder = IconInfo(0.45f, Offset(0.29f, 0.6f), alpha = 0f)
    )

    val SnowyComposed = ComposeInfo(
        sun = IconInfo(0.1f, Offset(0.75f, 0.2f), alpha = 0f),
        cloud = IconInfo(0.8f, Offset(0.1f, 0.1f)),
        lightCloud = IconInfo(0.5f, Offset(-0.15f, 0.35f), 0f),
        rains = IconInfo(0.4f, Offset(0.225f, 0.3f), alpha = 0f),
        lightRain = IconInfo(0.4f, Offset(0.225f, 0.3f), 0f),
        snow = IconInfo(0.5f, Offset(0.1f, 0.3f), alpha = 1f),
        thunder = IconInfo(0.45f, Offset(0.29f, 0.6f), alpha = 0f)

    )

    val ThunderStormComposed = ComposeInfo(
        sun = IconInfo(0.1f, Offset(0.75f, 0.2f), alpha = 0f),
        cloud = IconInfo(0.9f, Offset(0.06f, 0.05f)),
        lightCloud = IconInfo(0.5f, Offset(-0.05f, 0.125f), 0f),
        rains = IconInfo(0.45f, Offset(0.2f, 0.3f), alpha = 0f),
        lightRain = IconInfo(0.4f, Offset(0.225f, 0.3f), 0f),
        snow = IconInfo(0.5f, Offset(0.1f, 0.3f), alpha = 0f),
        thunder = IconInfo(0.5f, Offset(0.27f, 0.6f), alpha = 1f)

    )
}

/**
 * used in chart or navigation bar
 */
object WeatherIcon {
    val SunnyIcon = @Composable {
        Sun(Modifier.size(40.dp))
    }

    val MostlyClearIcon = @Composable {
        Box(Modifier.size(40.dp)) {
            Sun(
                Modifier
                    .size(40.dp)
                    .offset(3.dp)
            )
            Cloud(
                Modifier
                    .size(16.dp)
                    .offset(8.dp, 18.dp)
            )
        }
    }

    val CloudyIcon = @Composable {
        Cloud(
            Modifier
                .size(40.dp)
                .padding(3.dp)
        )
    }

    val RainIcon = @Composable {
        Box(Modifier.size(40.dp)) {
            Rains(
                Modifier
                    .size(25.dp)
                    .offset(5.dp, 8.dp),
                lightRain = true
            )
            Cloud(
                Modifier
                    .size(30.dp)
                    .align(Alignment.TopCenter)
            )
        }
    }

    val HeavyRainIcon = @Composable {
        Box(Modifier.size(40.dp)) {
            Rains(
                Modifier
                    .size(25.dp)
                    .offset(5.dp, 8.dp),
            )
            Cloud(
                Modifier
                    .size(30.dp)
                    .align(Alignment.TopCenter)
            )
        }
    }

    val SnowyIcon = @Composable {
        Box(Modifier.size(40.dp)) {
            Snow(
                Modifier
                    .size(20.dp)
                    .offset(3.dp, 8.dp),
            )
            Cloud(
                Modifier
                    .size(30.dp)
                    .align(Alignment.TopCenter)
            )
        }
    }

    val ThunderStormIcon = @Composable {
        Box(Modifier.size(40.dp)) {

            Cloud(
                Modifier
                    .size(30.dp)
                    .align(Alignment.TopCenter)
            )
            Thunder(
                Modifier
                    .size(20.dp)
                    .offset(10.dp, 18.dp),
            )
        }
    }
}

/**
 * used in navigation bar for selected item
 */
object WeatherAnimatableIcon {
    val SunnyAnimatableIcon = @Composable {
        AnimatableSun(
            Modifier
                .size(40.dp)
                .padding(2.dp)
        )
    }

    val MostlyClearAnimatableIcon = @Composable {
        Box(
            Modifier
                .size(40.dp)
        ) {
            AnimatableSun(
                Modifier
                    .size(40.dp)
                    .offset(3.dp)
            )
            Cloud(
                Modifier
                    .size(16.dp)
                    .offset(8.dp, 18.dp)
            )
        }
    }

    val CloudyAnimatableIcon = @Composable {
        AnimatableCloud(
            Modifier
                .size(40.dp)
                .padding(3.dp),
            800
        )
    }

    val RainAnimatableIcon = @Composable {
        Box(Modifier.size(40.dp)) {
            AnimatableRains(
                Modifier
                    .size(25.dp)
                    .offset(5.dp, 8.dp),
                true
            )
            Cloud(
                Modifier
                    .size(30.dp)
                    .align(Alignment.TopCenter)
            )
        }
    }

    val HeavyRainAnimatableIcon = @Composable {
        Box(Modifier.size(40.dp)) {
            AnimatableRains(
                Modifier
                    .size(25.dp)
                    .offset(5.dp, 8.dp)
            )
            Cloud(
                Modifier
                    .size(30.dp)
                    .align(Alignment.TopCenter)
            )
        }
    }

    val SnowAnimatableIcon = @Composable {
        Box(Modifier.size(40.dp)) {
            AnimatableSnow(
                Modifier
                    .size(20.dp)
                    .offset(3.dp, 8.dp),
            )
            Cloud(
                Modifier
                    .size(30.dp)
                    .align(Alignment.TopCenter)
            )
        }
    }

    val ThunderStormAnimatableIcon = @Composable {
        Box(Modifier.size(40.dp)) {
            Cloud(
                Modifier
                    .size(30.dp)
                    .align(Alignment.TopCenter)
            )
            AnimatableThunder(
                Modifier
                    .size(20.dp)
                    .offset(10.dp, 18.dp),
                300
            )
        }
    }
}