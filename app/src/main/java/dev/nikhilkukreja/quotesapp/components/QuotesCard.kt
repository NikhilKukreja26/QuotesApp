package dev.nikhilkukreja.quotesapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.nikhilkukreja.quotesapp.data.QuoteModel
import dev.nikhilkukreja.quotesapp.ui.theme.Normal14
import dev.nikhilkukreja.quotesapp.ui.theme.Normal8


@Composable
fun QuotesCard(
    modifier: Modifier = Modifier,
    quote: QuoteModel,
    onFavoriteClick: () -> Unit
) {
    Card(
        modifier = modifier
            .width(200.dp)
            .height(240.dp)
            .clip(
                RoundedCornerShape(16.dp)
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.linearGradient(
                        listOf<Color>(
                            quote.backgroundColor,
                            quote.backgroundColor.copy(alpha = 0.7f),
                        )
                    )
                )
                .padding(20.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                CircleShapeComponent(alpha = 0.04f)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    Icons.Default.Share,
                    contentDescription = "Share",
                    tint = Color.White

                )
//                Spacer(modifier = Modifier.width(8.dp))
                IconButton(
                    onClick = onFavoriteClick,
                ) {
                    Icon(
                        if (quote.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "Favorite",
                        tint = if (quote.isFavorite) Color.Red else Color.White
                    )
                }

            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = quote.text,
                style = MaterialTheme.typography.Normal14.copy(
                    color = Color.White,
                    lineHeight = 16.sp
                ),
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = quote.author,
                style = MaterialTheme.typography.Normal8.copy(
                    color = Color.White,
                    lineHeight = 16.sp,
                    fontStyle = FontStyle.Italic
                ),
            )

        }
    }
}
