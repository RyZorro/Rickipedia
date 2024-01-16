package com.example.rickipedia.Presentation.ViewModels

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickipedia.Application.DTOs.CharacterDto
import com.example.rickipedia.Application.UseCase.GetCharacterByIdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.IOException

/**
 * ViewModel responsible for managing data related to the character details screen.
 */
class CharacterDetailViewModel(private val getCharacterByIdUse: GetCharacterByIdUseCase): ViewModel() {

    // MutableStateFlow & StateFlow to hold the character Id
    private val _character = MutableStateFlow<CharacterDto?>(null)
    val character: StateFlow<CharacterDto?> = _character

    /**
     * Fetches character details based on the provided character ID.
     *
     * @param characterId The ID of the character to retrieve details for.
     */
    fun fetchCharacterById(characterId: String) {
        viewModelScope.launch {
            try {
                val result = getCharacterByIdUse.execute(characterId)
                _character.value = result
            } catch (e: IOException) {
                // Log network-related exceptions
                Log.e(TAG, "Network error: ${e.message}", e)
            } catch (e: Exception) {
                // Log any other unexpected exceptions
                Log.e(TAG, "Unexpected error: ${e.message}", e)
            }
        }
    }
}