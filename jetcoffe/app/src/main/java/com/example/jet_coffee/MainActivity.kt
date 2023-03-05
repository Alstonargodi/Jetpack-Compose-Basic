package com.example.jet_coffee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jet_coffee.model.Menu
import com.example.jet_coffee.model.dummyBestSellerMenu
import com.example.jet_coffee.model.dummyCategory
import com.example.jet_coffee.model.dummyMenu
import com.example.jet_coffee.ui.components.CategoryItem
import com.example.jet_coffee.ui.components.MenuItem
import com.example.jet_coffee.ui.components.SearchBar
import com.example.jet_coffee.ui.components.SectionText
import com.example.jet_coffee.ui.theme.JetcoffeeTheme
import java.util.Locale.Category

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetcoffeeTheme {
                // A surface container using the 'background' color from the theme
                JetCoffeApp()
            }
        }
    }
}

//main layout
@Composable
fun JetCoffeApp(){
    Column(
        modifier = Modifier.verticalScroll(
            rememberScrollState()
        )
    ) {
        Banner()
        SectionText(
            title = stringResource(id = R.string.section_category)
        )
        CategoryRow()
        SectionText(
            title = stringResource(id = R.string.section_favorite_menu)
        )
        MenuRow(list = dummyMenu)
        SectionText(
            title = stringResource(id = R.string.section_best_seller_menu)
        )
        MenuRow(list = dummyBestSellerMenu)
    }
}

@Composable
fun Banner(
    modifier: Modifier = Modifier
){
    Box (
        modifier = modifier
    ){
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(160.dp)
        )
        SearchBar()
    }
}

@Composable
fun CategoryRow(
    modifier: Modifier = Modifier
){
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ){
        items(
            dummyCategory,
            key = { it.textCategory }
        ){ data ->
            CategoryItem(category = data)
        }
    }
}

@Composable
fun MenuRow(
    list: List<Menu>,
    modifier: Modifier = Modifier
){
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ){
        items(
            list,
            key = { it.title }
        ){ data ->
            MenuItem(data)
        }
    }
}

@Preview(
    showBackground = false,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    JetcoffeeTheme {
        JetCoffeApp()
    }
}