package com.example.weather_compose.presentasion.home.searchbar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopbarSearch(
    search : String,
    placeHolderText: String = "",
    onSearchText: (String) -> Unit = {},
    onSearchClick: () -> Unit = {},
    navigateToAbout: () -> Unit,
){
    Box {
        Column {
            SearchBar(
                search = search,
                placeHolderText = placeHolderText,
                onSearchText = onSearchText,
                onSearchClick = onSearchClick,
                navigateToAbout = navigateToAbout
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    search : String,
    navigateToAbout: () -> Unit,
    placeHolderText: String = "",
    onSearchText: (String) -> Unit = {},
    onSearchClick: () -> Unit = {}
){
    var isSearch by remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            Text(
                text = "Gitu",
                style = TextStyle( color = Color.White),
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        },
        actions = {
            AnimatedVisibility(
                visible = isSearch
            ) {
                OutlinedTextField(
                    value = search,
                    modifier= Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Gray),
                    onValueChange = { onSearchText(it) },
                    placeholder = { Text(text = placeHolderText) },
                    maxLines = 1,
                    singleLine = true,
                    keyboardActions = KeyboardActions(
                        onDone = { onSearchClick() }
                    ),
                    textStyle = TextStyle(color = Color.White),
                    trailingIcon = {
                        Row {
                            IconButton(
                                modifier = Modifier.padding(1.dp),
                                onClick = { onSearchClick() }
                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.Search,
                                    modifier = Modifier,
                                    contentDescription = "search",
                                    tint = Color.White
                                )
                            }
                            IconButton(
                                modifier = Modifier.padding(1.dp),
                                onClick = { isSearch = false }
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Close,
                                    modifier = Modifier.width(20.dp),
                                    contentDescription = "close",
                                    tint = Color.White
                                )
                            }
                        }
                    },
                )
            }
            IconButton(onClick = { isSearch = true }) {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    modifier = Modifier,
                    contentDescription = "search weather",
                    tint = Color.White
                )
            }
            IconButton(
                modifier = Modifier.padding(2.dp),
                onClick = { navigateToAbout() }
            ) {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    modifier = Modifier.width(20.dp),
                    contentDescription = "klik button",
                    tint = Color.White
                )
            }
        },
    )
}