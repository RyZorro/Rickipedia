package com.example.rickipedia.Presentation.ViewModels

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickipedia.Application.DTOs.CharacterDto
import com.example.rickipedia.Application.UseCase.GetAllCharactersUseCase
import com.example.rickipedia.Application.UseCase.SearchCharacterUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.io.IOException

/**
 * ViewModel responsible for managing the UI-related data for the HomeScreen.
 * @param characterUseCase The use case responsible for fetching character data.
 */
class CharacterListViewModel(
    private val characterUseCase: GetAllCharactersUseCase,
    private val searchCharacterUseCase: SearchCharacterUseCase
) : ViewModel() {

    // MutableStateFlow to hold the list of characters
    private val _characterList = MutableStateFlow<List<CharacterDto>>(emptyList())

    // Exposed immutable StateFlow for observing the list of characters
    val characterList: MutableStateFlow<List<CharacterDto>> = _characterList

    /**
     * Fetches characters from the repository using the provided use case and updates the StateFlow.
     * Logs any network-related errors and unexpected exceptions.
     */
    fun fetchCharacters() {
        viewModelScope.launch {
            try {

                // Fetch characters from the use case
                val characters = characterUseCase.getAllCharacters()

                // Update the StateFlow
                _characterList.value = characters

            } catch (e: IOException) {

                // Log network-related exceptions
                Log.e(TAG, "Network error: ${e.message}", e)

            } catch (e: Exception) {

                // Catch any other unexpected exceptions
                Log.e(TAG, "Unexpected error: ${e.message}", e)
            }
        }
    }

    /**
     * Initiates a search for characters based on the provided query using the SearchCharacterUseCase.
     * @param query The search query.
     */
    fun searchCharacters(query: String) {
        viewModelScope.launch {
            try {
                // Execute the search using the SearchCharacterUseCase
                val result = searchCharacterUseCase.execute(query)

                // Update the list of characters with the search results
                _characterList.value = result
            } catch (e: IOException) {
                // Log network-related exceptions
                Log.e(TAG, "Network error: ${e.message}", e)
                // Handle network errors if needed
            } catch (e: Exception) {
                // Log any other unexpected exceptions
                Log.e(TAG, "Unexpected error: ${e.message}", e)
                // Handle other exceptions if needed
            }
        }
    }
}