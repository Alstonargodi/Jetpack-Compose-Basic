package com.example.mysoothe

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mysoothe.components.*
import com.example.mysoothe.ui.theme.MySootheTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MySootheTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}



@Composable
fun HomeScreen(modifier: Modifier = Modifier){
    Column(
        modifier
            .verticalScroll(rememberScrollState())
            .padding(vertical = 16.dp)
    ) {
        SearchBar(modifier = Modifier.padding(horizontal = 16.dp))
        HomeSection(title = "Bocchi Home") {
            AlignBodyRow()
        }
        HomeSection(title = "Bocchi Home") {
            FavoriteCollectionGrid()
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun HomeSectionPreview(){
    MySootheTheme {
       Scaffold(
           bottomBar = {
               BottomNavigationHome()
           }
       ) { padding ->
           HomeScreen(
               Modifier.padding(padding)
           )
       }
    }
}




