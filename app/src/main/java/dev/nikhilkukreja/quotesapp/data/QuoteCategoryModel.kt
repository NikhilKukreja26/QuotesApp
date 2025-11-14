package dev.nikhilkukreja.quotesapp.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import dev.nikhilkukreja.quotesapp.utils.AppStrings

data class QuoteCategoryModel(
    val name: String,
    val icon: ImageVector,
    val category: QuoteCat,
    val color: Color,
)

val quoteCategories: List<QuoteCategoryModel> = listOf<QuoteCategoryModel>(
    QuoteCategoryModel(
        name = AppStrings.life,
        icon = Icons.Default.Favorite,
        category = QuoteCat.LIFE,
        color = Color(0xFF1E40AF)
    ),
    QuoteCategoryModel(
        name = AppStrings.motivation,
        icon = Icons.Default.Star,
        category = QuoteCat.MOTIVATION,
        color = Color(0xFFD46A05)
    ),
    QuoteCategoryModel(
        name = AppStrings.success,
        icon = Icons.Default.Check,
        category = QuoteCat.SUCCESS,
        color = Color(0xFF218A5F)
    ),
    QuoteCategoryModel(
        name = AppStrings.wisdom,
        icon = Icons.Default.Info,
        category = QuoteCat.WISDOM,
        color = Color(0xFF6B31E9)
    ),
    QuoteCategoryModel(
        name = AppStrings.love,
        icon = Icons.Default.FavoriteBorder,
        category = QuoteCat.LOVE,
        color = Color(0xFFC84B4D)
    ),
    QuoteCategoryModel(
        name = AppStrings.courage,
        icon = Icons.Default.Warning,
        category = QuoteCat.COURAGE,
        color = Color(0xFF2886A7)
    ),
    QuoteCategoryModel(
        name = AppStrings.leadership,
        icon = Icons.Default.Person,
        category = QuoteCat.LEADERSHIP,
        color = Color(0xFFBDBFC3)
    ),
)
