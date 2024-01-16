package com.example.rickipedia.Application.UseCase

import com.example.rickipedia.Application.DTOs.CharacterDto

/**
 * Interface defining the contract for executing the use case to get a specific character by ID.
 */
interface GetCharacterByIdUseCase {
    suspend fun execute(characterId: String): CharacterDto
}