package dev.nikhilkukreja.quotesapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SelectableChipColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.nikhilkukreja.quotesapp.components.QuoteTile
import dev.nikhilkukreja.quotesapp.data.QuoteCategoryModel
import dev.nikhilkukreja.quotesapp.data.quoteCategories
import dev.nikhilkukreja.quotesapp.data.quotes
import dev.nikhilkukreja.quotesapp.ui.theme.Bold20
import dev.nikhilkukreja.quotesapp.utils.AppStrings

@Composable
fun ExploreScreen(
    modifier: Modifier = Modifier,
    selectedCategory: String?
) {
    var selectedQuoteCategory: QuoteCategoryModel? by remember { mutableStateOf(null) }

    if(selectedCategory != null) {
        selectedQuoteCategory = quoteCategories.find { it.category.name == selectedCategory }
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {

        item {
            Text(
                text = AppStrings.categories,
                style = MaterialTheme.typography.Bold20.copy(fontSize = 24.sp)
            )
        }

        item {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(quoteCategories.size) { index ->
                    FilterChip(
                        selected = selectedQuoteCategory == quoteCategories[index],
                        onClick = {
                            selectedQuoteCategory = quoteCategories[index]
                        },
                        label = {
                            Text(text = quoteCategories[index].name)
                        },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = quoteCategories[index].color,
                            selectedLabelColor = MaterialTheme.colorScheme.onPrimary,
                        )
                    )
                }
            }
        }

//        items(quotes.size) {index ->
//            QuoteTile(
//                quote = quotes[index],
//            )
//
//        }

    }
}