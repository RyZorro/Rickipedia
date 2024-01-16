package com.example.rickipedia.Infrastructure.ExternalService

import com.example.rickipedia.Application.DTOs.CharacterDto
import com.example.rickipedia.Domain.Entities.CharacterList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Interface defining the contract for interacting with the external Rick and Morty API.
 * This interface adheres to Domain-Driven Design (DDD) principles by focusing on a clear contract for character-related operations and separation of concerns.
 */
interface RickAndMortyApi {

    /**
     * Fetches all characters from the Rick and Morty API.
     * @return CharacterList representing the response containing a list of characters.
     */
    @GET("character")
    suspend fun fetchAllCharacters(): CharacterList

    /**
     * Fetches all characters from the Rick and Morty API.
     * @return CharacterList representing the response based off a search query.
     */
    @GET("character")
    suspend fun searchCharacter(@Query("name") name: String): CharacterList

    /**
     * Defines an endpoint to fetch a specific character by ID from the Rick and Morty API.
     * @param characterId The ID of the character to fetch.
     * @return The fetched CharacterDto representing the specific character.
     */
    @GET("character/{id}")
    suspend fun fetchCharacter(@Path("id") characterId: String): CharacterDto
}