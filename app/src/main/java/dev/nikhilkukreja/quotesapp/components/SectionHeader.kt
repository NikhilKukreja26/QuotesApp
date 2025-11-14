package dev.nikhilkukreja.quotesapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.nikhilkukreja.quotesapp.ui.theme.Medium16
import dev.nikhilkukreja.quotesapp.utils.AppStrings

@Composable
fun SectionHeader(
    modifier: Modifier = Modifier,
    startText: String,
    endText: String = AppStrings.viewAll,
    onEndTextClick: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = startText,
            style = MaterialTheme.typography.Medium16,
        )
        TextButton(
            onClick = onEndTextClick,
        ) {
            Text(
                text = endText,
                style = MaterialTheme.typography.Medium16,
            )
        }
    }
}