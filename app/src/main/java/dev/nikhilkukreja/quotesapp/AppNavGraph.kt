package dev.nikhilkukreja.quotesapp

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import dev.nikhilkukreja.quotesapp.screens.ExploreScreen
import dev.nikhilkukreja.quotesapp.screens.HomeScreen
import dev.nikhilkukreja.quotesapp.screens.SavedScreen

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
) {
    NavHost(
        navController = navHostController,
        startDestination = DestinationsRoutes.Home.route
    ) {
        composable(
            DestinationsRoutes.Home.route
        ) {
            HomeScreen(
                modifier = modifier,
                onNavigateToExplore = { category ->
                    val encoded = Uri.encode(category)
                    navHostController.navigate("${DestinationsRoutes.Explore.route}?category=$encoded")
                }
            )
        }
        composable(
            "${DestinationsRoutes.Explore.route}?category={category}",
            arguments = listOf(navArgument("category") {
                type = NavType.StringType
                nullable = true
            }),
        ) { backstackEntry ->

            val category = backstackEntry.arguments?.getString("category")

            ExploreScreen(
                modifier = modifier,
                selectedCategory = category,
            )
        }
        composable(DestinationsRoutes.Saved.route) {
            SavedScreen(
                modifier = modifier
            )
        }
    }
}