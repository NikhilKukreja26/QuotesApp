package dev.nikhilkukreja.quotesapp

sealed class DestinationsRoutes(val route: String) {
    data object Home : DestinationsRoutes("home")
    data object Explore : DestinationsRoutes("explore")
    data object Saved : DestinationsRoutes("saved")
}
