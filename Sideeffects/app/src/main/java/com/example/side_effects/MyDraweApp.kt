package com.example.side_effects

import android.icu.text.CaseMap.Title
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.SnackbarResult
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.side_effects.ui.theme.SideeffectsTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDrawerApp(){
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    androidx.compose.material.Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            MyTopBar (
                onMenuClick = {
                    scope.launch{
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        drawerContent = {
            MyDrawerContent(
                onItemSelected = { title ->
                    scope.launch {
                        scaffoldState.drawerState.close()
                        val snackbarResult = scaffoldState.snackbarHostState.showSnackbar(
                            message = context.resources.getString(R.string.coming_soon, title),
                            actionLabel = context.resources.getString(R.string.subscribe_question)
                        )
                        if (snackbarResult == SnackbarResult.ActionPerformed){
                            Toast.makeText(
                                context,
                                context.resources.getString(R.string.subscribed_info),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                },
                onBackPres = {
                        if (scaffoldState.drawerState.isOpen){
                            scope.launch {
                                scaffoldState.drawerState.close()
                            }
                        }
                    }
                )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ){
            Text(stringResource(R.string.hello_world))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(onMenuClick: () -> Unit){
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { onMenuClick() }) {
                Icon(
                    imageVector = Icons.Default.Menu ,
                    contentDescription =  "Menu"
                )
            }
        },
        title = {
            Text(text = stringResource(id = R.string.app_name))
        },
    )
}

@Composable
fun MyDrawerContent(
    modifier: Modifier = Modifier,
    onItemSelected: (title: String) -> Unit,
    onBackPres: () -> Unit
) {
    val items = listOf(
        MenuItem(
            title = stringResource(R.string.home),
            icon = Icons.Default.Home
        ),
        MenuItem(
            title = stringResource(R.string.favourite),
            icon = Icons.Default.Favorite
        ),
        MenuItem(
            title = stringResource(R.string.profile),
            icon = Icons.Default.AccountCircle
        ),
    )
    Column(modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .height(190.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
        )
        for (item in items) {
            Row(
                modifier = Modifier
                    .clickable { onItemSelected(item.title) }
                    .padding(vertical = 12.dp, horizontal = 16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.title,
                    tint = Color.DarkGray
                )
                Spacer(modifier = Modifier.width(32.dp))
                Text(text = item.title, style = MaterialTheme.typography.labelLarge)
            }
        }
        Divider()
    }
    BackPressHandler {
        onBackPres()
    }
}


@Preview
@Composable
fun previewMenu(){
    SideeffectsTheme {
        MyDrawerApp()
    }
}

