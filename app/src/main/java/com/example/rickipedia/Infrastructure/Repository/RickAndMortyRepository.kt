package com.example.rickipedia.Infrastructure.Repository

import com.example.rickipedia.Application.DTOs.CharacterDto
import com.example.rickipedia.Application.Mapper.CharacterMapper
import com.example.rickipedia.Application.Wrapper.CharacterWrapper
import com.example.rickipedia.Infrastructure.ExternalService.RickAndMortyApi

/**
 * The RickAndMortyRepository class fetches all characters from the Rick and Morty API.
 * It adheres to SOLID principles by encapsulating logic, depending on abstractions, and separating concerns
 * It follows DDD principles with a clear contract for character-related operations.
 */
class RickAndMortyRepository(
    private val rickAndMortyApi: RickAndMortyApi,
    private val characterMapper: CharacterMapper,
    private val characterWrapper: CharacterWrapper<CharacterDto>
) {
    /**
     * Fetches all characters from the Rick and Morty API.
     * @return List of CharacterDto representing all characters.
     */
    suspend fun fetchAllCharacters(): List<CharacterDto> {
        // Fetch all characters from the API
        val allCharactersApiResponse = rickAndMortyApi.fetchAllCharacters()

        // Map and wrap characters
        return allCharactersApiResponse.results.map { character ->
            // Map the character to CharacterDto using the provided mapper
            val characterDto = characterMapper.toDto(character)

            // Wrap the CharacterDto using the provided wrapper
            characterWrapper.wrap(characterDto)
        }
    }

    /**
     * Fetches all characters from the Rick and Morty API based on a search query.
     * @param query The search query to filter characters.
     * @return List of CharacterDto representing characters matching the search query.
     */
    suspend fun searchCharacter(query: String): List<CharacterDto> {
        // Fetch characters based on the search query from the API
        val searchResult = rickAndMortyApi.searchCharacter(query)

        // Map and wrap characters
        return searchResult.results.map { character ->
            // Map the character to CharacterDto using the provided mapper
            val characterDto = characterMapper.toDto(character)

            // Wrap the CharacterDto using the provided wrapper
            characterWrapper.wrap(characterDto)
        }
    }

    /**
     * Fetches a specific character by ID from the Rick and Morty API.
     * @param characterId The ID of the character to fetch.
     * @return The fetched CharacterDto representing the specific character.
     */
    suspend fun fetchCharacter(characterId: String): CharacterDto {
        return rickAndMortyApi.fetchCharacter(characterId)
    }
}