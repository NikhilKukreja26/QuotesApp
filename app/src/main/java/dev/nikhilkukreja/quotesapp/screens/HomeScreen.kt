package dev.nikhilkukreja.quotesapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.nikhilkukreja.quotesapp.components.QuoteCategory
import dev.nikhilkukreja.quotesapp.components.QuotesCard
import dev.nikhilkukreja.quotesapp.components.SectionHeader
import dev.nikhilkukreja.quotesapp.data.QuoteModel
import dev.nikhilkukreja.quotesapp.data.quoteCategories
import dev.nikhilkukreja.quotesapp.data.quotes
import dev.nikhilkukreja.quotesapp.data.sharedQuotes
import dev.nikhilkukreja.quotesapp.ui.theme.Bold20
import dev.nikhilkukreja.quotesapp.ui.theme.Normal12
import dev.nikhilkukreja.quotesapp.ui.theme.QuotesAppTheme
import dev.nikhilkukreja.quotesapp.utils.AppStrings

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onNavigateToExplore: (category: String?) -> Unit = {}
) {

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = AppStrings.explore,
                style = MaterialTheme.typography.Bold20.copy(fontSize = 24.sp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = AppStrings.awesomeQuotes,
                style = MaterialTheme.typography.Normal12.copy(color = Color.Black.copy(alpha = 0.8f)),
            )
        }
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .height(220.dp)
                    .background(color = Color.Blue),
                contentAlignment = Alignment.Center


            ) {
                Text(
                    text = AppStrings.believeInYourself,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineMedium.copy(
                        color = Color.White
                    )
                )
            }
        }
        item {
            SectionHeader(
                startText = AppStrings.latestQuotes,
                onEndTextClick = {
                    onNavigateToExplore(null)
                },
            )
        }

        item {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                items(sharedQuotes.size) { index ->
                    QuotesCard(
                        quote = sharedQuotes[index],
                        onFavoriteClick = {
                            sharedQuotes[index] = sharedQuotes[index].copy(isFavorite = !sharedQuotes[index].isFavorite)

                        }
                    )
                }
            }
        }

        item {
            SectionHeader(
                startText = AppStrings.categories,
                onEndTextClick = {
                    onNavigateToExplore(null)
                },
            )
        }

        item {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(quoteCategories.size) { index ->
                    QuoteCategory(
                        quoteCategory = quoteCategories[index],
                        onClick = {
                            onNavigateToExplore(quoteCategories[index].category.name)
                        }
                    )
                }
            }
        }

        item {
            SectionHeader(
                startText = AppStrings.trendingQuotes,
                onEndTextClick = {
                    onNavigateToExplore(null)
                },
            )
        }

        item {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                items(sharedQuotes.size) { index ->
                    QuotesCard(
                        quote = sharedQuotes[index],
                        onFavoriteClick = {
                            sharedQuotes[index] = sharedQuotes[index].copy(isFavorite = !sharedQuotes[index].isFavorite)

                        }
                    )
                }
            }
        }


    }
}

@Preview(showBackground = true)
@Composable
fun QuotesPreview() {
    QuotesAppTheme {
        HomeScreen()
    }
}