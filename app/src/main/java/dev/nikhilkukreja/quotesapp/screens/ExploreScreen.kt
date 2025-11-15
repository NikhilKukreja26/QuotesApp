package dev.nikhilkukreja.quotesapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.nikhilkukreja.quotesapp.data.QuoteCategoryModel
import dev.nikhilkukreja.quotesapp.data.quoteCategories
import dev.nikhilkukreja.quotesapp.ui.theme.Bold20
import dev.nikhilkukreja.quotesapp.utils.AppStrings
import kotlinx.coroutines.launch

@Composable
fun ExploreScreen(
    modifier: Modifier = Modifier,
    selectedCategory: String?,
) {
    val lazyListState = rememberLazyListState()

    val scope = rememberCoroutineScope()

    var selectedQuoteCategory: QuoteCategoryModel? by remember { mutableStateOf(null) }

    if (selectedCategory != null) {
        selectedQuoteCategory = quoteCategories.find { it.category.name == selectedCategory }
        LaunchedEffect(Unit) {
            val index = quoteCategories.indexOf(selectedQuoteCategory)

            if (index != -1) {
                val targetIndex = (index - 1).coerceAtLeast(0)
                lazyListState.animateScrollToItem(targetIndex)
            }
        }
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
                state = lazyListState,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(quoteCategories.size) { index ->
                    val quoteCategory = quoteCategories[index]
                    FilterChip(
                        selected = selectedQuoteCategory == quoteCategory,
                        onClick = {
                            selectedQuoteCategory = quoteCategory
                            scope.launch {
                                if (index != -1) {
                                    val targetIndex = (index - 1).coerceAtLeast(0)
                                    lazyListState.animateScrollToItem(targetIndex)
                                }
                            }
                        },
                        label = {
                            Text(text = quoteCategory.name)
                        },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = quoteCategory.color,
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