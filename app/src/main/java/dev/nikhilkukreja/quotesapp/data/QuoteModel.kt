package dev.nikhilkukreja.quotesapp.data

import androidx.compose.ui.graphics.Color
import dev.nikhilkukreja.quotesapp.utils.AppStrings

data class QuoteModel(
    val text: String,
    val author: String,
    val backgroundColor: Color,
    val category: QuoteCat = QuoteCat.LIFE,
    val isFavorite: Boolean = false
)

enum class  QuoteCat {
    LIFE,
    MOTIVATION,
    SUCCESS,
    WISDOM,
    LOVE,
    COURAGE,
    LEADERSHIP,
}

val quotes: List<QuoteModel> = listOf<QuoteModel>(
    QuoteModel(
        text = AppStrings.neverForget,
        author = AppStrings.igGlossyMinds,
        backgroundColor = Color(0xFF1E40AF)
    ),
    QuoteModel(
        text = AppStrings.priceOfGreatness,
        author = AppStrings.igGlossyMinds,
        backgroundColor = Color(0xFF2C3440),
        category = QuoteCat.LEADERSHIP
    ),
    QuoteModel(
        text = AppStrings.everythingYouCan,
        author = AppStrings.pabloPicasso,
        backgroundColor = Color(0xFFD97B1F),
        category = QuoteCat.MOTIVATION

    ),

)
