package com.example.rickipedia.Presentation.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.example.rickipedia.Presentation.Components.CharacterItem
import com.example.rickipedia.Presentation.Components.SearchBar
import com.example.rickipedia.Presentation.Screen.Screen
import com.example.rickipedia.Presentation.ViewModels.CharacterListViewModel

@Composable
fun HomeScreen(
    characterListViewModel: CharacterListViewModel,
    navController: NavController
) {
    // State for managing the search query
    var searchQuery by remember { mutableStateOf("") }

    // Collecting characters from the view model as state

    val characters by characterListViewModel.characterList.collectAsState()
    // Fetching all characters when the screen launches

    LaunchedEffect(Unit) {
        characterListViewModel.fetchCharacters()
    }

    // Column composable for arranging UI elements vertically
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF222222))
            .padding(16.dp)
    ) {
        // Search bar for user input
        SearchBar(
            searchQuery = searchQuery,
            modifier = Modifier.fillMaxWidth(),
            onSearchQueryChange = { newQuery ->
                // Updating the search query and triggering search in view model
                searchQuery = newQuery
                characterListViewModel.searchCharacters(newQuery)
            }
        )

        // Adding space between elements
        Spacer(modifier = Modifier.height(16.dp))

        // LazyColumn for displaying characters in rows
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            // Splitting characters into rows of two and displaying them
            items(items = characters.chunked(2)) { charactersInRow ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Displaying characters in individual boxes in a row
                    charactersInRow.forEach { character ->
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .padding(4.dp)
                                .clickable {
                                    // Navigate to detail screen passing character ID
                                    navController.navigate("${Screen.Detail.route}/${character.id}")
                                }
                        ) {
                            // Displaying each character using CharacterItem composable
                            CharacterItem(
                                character = character
                            )
                        }
                    }
                }
            }
        }
    }
}