package com.example.weather_compose.presentasion.customicon.weathericon

import android.graphics.drawable.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weather_compose.R

@Composable
fun AnimatableCloud(
    modifier: Modifier = Modifier,
    durationMilis: Int = 1500
){
    val transition = rememberInfiniteTransition()

    val animateTween by transition.animateFloat(
        initialValue = -1f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            tween(durationMilis, easing = LinearEasing),
            RepeatMode.Reverse
        ), label = ""
    )

    Cloud(modifier = modifier.offset(5.dp * animateTween))
}

@Composable
fun Cloud(modifier: Modifier = Modifier) {

    Image(
        imageVector = ImageVector.vectorResource(id = R.drawable.baseline_cloud_24),
        contentDescription = "",
        modifier = modifier.clearAndSetSemantics { }
    )
}

@Preview
@Composable
fun PreviewAnimatableCloud() {
    AnimatableCloud()
}