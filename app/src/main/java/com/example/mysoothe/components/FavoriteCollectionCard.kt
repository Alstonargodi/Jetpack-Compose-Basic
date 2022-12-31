package com.example.mysoothe.components

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import com.example.mysoothe.R

@Composable
fun FavoriteCollectionCard(
    @DrawableRes drawable : Int,
    @SuppressLint("SupportAnnotationUsage") @StringRes text : String,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(192.dp)
        ){
            Image(
                painter = painterResource(
                    id = drawable
                ),
                contentDescription = "image",
                modifier = Modifier.size(56.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(horizontal = 16.dp),
                text = text
            )
        }
    }
}