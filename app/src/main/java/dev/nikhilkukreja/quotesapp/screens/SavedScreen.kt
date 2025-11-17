package dev.nikhilkukreja.quotesapp.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.nikhilkukreja.quotesapp.components.QuoteTile
import dev.nikhilkukreja.quotesapp.data.sharedQuotes
import dev.nikhilkukreja.quotesapp.ui.theme.Bold20
import dev.nikhilkukreja.quotesapp.utils.AppStrings

@Composable
fun SavedScreen(modifier: Modifier = Modifier) {

//    val favoriteQuotes by remember {
//        derivedStateOf {
//            sharedQuotes.filter { it.isFavorite }
//        }
//    }

    val favoriteQuotes =  sharedQuotes.filter { it.isFavorite }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {



        item {
            Text(
                text = AppStrings.saved,
                style = MaterialTheme.typography.Bold20.copy(fontSize = 24.sp)
            )
        }

        items(favoriteQuotes.size) {index->
            val quote = favoriteQuotes[index]
            QuoteTile(quote = quote)
        }


    }
}