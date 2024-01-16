package com.example.rickipedia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.rickipedia.Application.ViewModelProvider.ViewModelProviderImpl
import com.example.rickipedia.Presentation.Screen.Screen
import com.example.rickipedia.Presentation.Screens.DetailScreen
import com.example.rickipedia.Presentation.Screens.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val characterListViewModel = ViewModelProviderImpl().provideCharacterListViewModel()
            val characterDetailViewModel = ViewModelProviderImpl().provideCharacterDetailViewModel()

            NavHost(navController, startDestination = Screen.Home.route) {
                // Define a composable for the HomeScreen
                composable(Screen.Home.route) {
                    HomeScreen(characterListViewModel, navController)
                }
                // Define a composable for the DetailScreen with route containing characterId
                composable(
                    route = Screen.Detail.route + "/{characterId}",
                    // Define arguments for characterId as StringType
                    arguments = listOf(navArgument("characterId") { type = NavType.StringType })
                ) { navBackStackEntry ->
                    // Extract the characterId from the arguments passed during navigation
                    val characterId =
                        navBackStackEntry.arguments?.getString("characterId") ?: return@composable
                    // Display the DetailScreen with characterId and ViewModels
                    DetailScreen(
                        characterId = characterId,
                        viewModel = characterDetailViewModel,
                    )
                }
            }
        }
    }
}