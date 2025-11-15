package dev.nikhilkukreja.quotesapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.nikhilkukreja.quotesapp.data.QuoteModel
import dev.nikhilkukreja.quotesapp.ui.theme.Bold12
import dev.nikhilkukreja.quotesapp.ui.theme.Bold14
import dev.nikhilkukreja.quotesapp.ui.theme.Bold16
import dev.nikhilkukreja.quotesapp.ui.theme.Medium10
import dev.nikhilkukreja.quotesapp.ui.theme.Medium12
import dev.nikhilkukreja.quotesapp.ui.theme.Medium14
import dev.nikhilkukreja.quotesapp.ui.theme.Normal14

@Composable
fun QuoteTile(
    modifier: Modifier = Modifier,
    quote: QuoteModel,
) {
    Card(
        modifier = modifier.padding(
            top = 16.dp,
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.5.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = quote.backgroundColor.copy(alpha = 0.05f)
                )
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(quote.backgroundColor.copy(alpha = 0.2f), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        tint = Color(0xFF1E88E5),
                        modifier = Modifier.size(28.dp)
                    )
                }

                Text(
                    text = quote.category.displayName,
                    style = MaterialTheme.typography.Bold12.copy(
                        color = quote.backgroundColor,
                    ),
                )
            }

            Text(text = quote.text, style = MaterialTheme.typography.Bold14)

            Text(
                text = quote.author,
                style = MaterialTheme.typography.Medium12.copy(
                    color = quote.backgroundColor,
                    fontStyle = FontStyle.Italic,
                ),
            )
        }
    }
}