import android.annotation.SuppressLint
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White

val Red700 = Color(0xffdd0d3c)
val Red800 = Color(0xffd00036)
val Red900 = Color(0xffc20029)

@SuppressLint("ConflictingOnColor")
val LightColors = lightColors(
    primary = Red700,
    primaryVariant = Red900,
    onPrimary = White,
    secondary = Red700,
    secondaryVariant = Red900,
    onSecondary = White,
    error = Red800
)

val Red200 = Color(0xfff297a2)
val Red300 = Color(0xffea6d7e)

val DarkColors = darkColors(
    primary = Red300,
    primaryVariant = Red700,
    onPrimary = Color.Black,
    secondary = Red300,
    onSecondary = Color.Black,
    error = Red200
)