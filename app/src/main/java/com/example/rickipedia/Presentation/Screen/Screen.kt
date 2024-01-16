package com.example.rickipedia.Presentation.Screen

/**
 * Represents different screens/routes in the app.
 */
sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Detail : Screen("detail/{characterId}")
}