package com.example.rickipedia.Application.UseCase

import com.example.rickipedia.Application.DTOs.CharacterDto

/**
 * Interface defining the contract for a use case that retrieves a list of characters.
 * This use case is designed to be asynchronous.
 */
interface GetAllCharactersUseCase {

    /**
     * Asynchronously retrieves a list of characters.
     * @return A list of CharacterDto representing characters.
     */
    suspend fun getAllCharacters(): List<CharacterDto>
}