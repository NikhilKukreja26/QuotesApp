package dev.nikhilkukreja.quotesapp.data

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.graphics.Color
import dev.nikhilkukreja.quotesapp.utils.AppStrings

data class QuoteModel(
    val text: String,
    val author: String,
    val backgroundColor: Color,
    val category: QuoteCat = QuoteCat.LIFE,
    val isFavorite: Boolean = false
)

enum class  QuoteCat(val displayName: String) {
    LIFE(AppStrings.life),
    MOTIVATION(AppStrings.motivation),
    SUCCESS(AppStrings.success),
    WISDOM(displayName = AppStrings.wisdom),
    LOVE(AppStrings.love),
    COURAGE(AppStrings.courage),
    LEADERSHIP(AppStrings.leadership),
}

val quotes: List<QuoteModel> = listOf<QuoteModel>(
    QuoteModel(
        text = AppStrings.neverForget,
        author = AppStrings.igGlossyMinds,
        backgroundColor = Color(0xFF1E40AF)
    ),
    QuoteModel(
        text = AppStrings.lifeIsReallySimple,
        author = AppStrings.confucius,
        backgroundColor = Color(0xFF1E40AF)
    ),
    QuoteModel(
        text = AppStrings.inTheMiddleOfDifficulty,
        author = AppStrings.albertEinstein,
        backgroundColor = Color(0xFF1E40AF)
    ),
    QuoteModel(
        text = AppStrings.thePurposeOfLife,
        author = AppStrings.emerson,
        backgroundColor = Color(0xFF1E40AF)
    ),
    QuoteModel(
        text = AppStrings.yourLifeIsYourJourney,
        author = AppStrings.confucius,
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

val sharedQuotes = mutableStateListOf<QuoteModel>().apply {
    addAll(quotes)
}
