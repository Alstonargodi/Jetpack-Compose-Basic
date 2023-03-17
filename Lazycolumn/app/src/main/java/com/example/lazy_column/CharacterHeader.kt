package com.example.lazy_column

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lazy_column.data.HeroRepository
import com.example.lazy_column.data.JetHeroesViewModel
import com.example.lazy_column.data.ViewModelFactory
import com.example.lazy_column.model.HeroesData

@Composable
fun CharacterHeader(
    char: Char,
    modifier: Modifier = Modifier
){
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier
    ) {
        Text(
            text = char.toString(),
            fontWeight = FontWeight.Black,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
    }
}


//@OptIn(ExperimentalFoundationApi::class)
//@Composable
//fun JetHeroesApp(
//    modifier: Modifier = Modifier,
//    viewModel : JetHeroesViewModel = viewModel(
//        factory =  ViewModelFactory(HeroRepository())
//    )
//) {
//    val groupHeroes by viewModel.groupHeroes.collectAsState()
//
//    Box (
//        modifier = Modifier
//            .padding(20.dp)
//    ){
//        LazyColumn(
//            contentPadding = PaddingValues(bottom = 80.dp)
//        ){
//            groupHeroes.forEach{ (initial,heroes) ->
//                stickyHeader {
//                    CharacterHeader(char = initial)
//                }
//                items(heroes, key = {it.id}){ hero ->
//                    HeroListItem(
//                        name = hero.name,
//                        photoUrl =hero.photoUrl,
//                        modifier = Modifier.fillMaxWidth()
//                    )
//                }
//
//            }
//        }
//    }
//}
//
