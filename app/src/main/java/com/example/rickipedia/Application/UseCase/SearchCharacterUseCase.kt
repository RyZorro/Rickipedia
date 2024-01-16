package com.example.rickipedia.Application.UseCase

import com.example.rickipedia.Application.DTOs.CharacterDto

/**
* This interface defines the contract for an operation related to fetching all characters.
*/
interface SearchCharacterUseCase {
    suspend fun execute(query: String): List<CharacterDto>
}