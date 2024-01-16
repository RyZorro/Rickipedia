package com.example.rickipedia.Application.UseCaseImpl

import com.example.rickipedia.Application.DTOs.CharacterDto
import com.example.rickipedia.Application.UseCase.GetCharacterByIdUseCase
import com.example.rickipedia.Infrastructure.Repository.RickAndMortyRepository

/**
 * Implementation of the GetCharacterByIdUseCase interface, responsible for executing the use case to get a specific character by ID.
 * This class delegates the task to the RickAndMortyRepository.
 */
class GetCharacterByIdUseCaseImpl(private val rickAndMortyRepository: RickAndMortyRepository): GetCharacterByIdUseCase {

    /**
     * Executes the use case to get a specific character by ID.
     * @param characterId The ID of the character to retrieve.
     * @return The CharacterDto representing the specific character.
     */
    override suspend fun execute(characterId: String): CharacterDto {
        return rickAndMortyRepository.fetchCharacter(characterId)
    }

}