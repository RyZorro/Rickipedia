package com.example.rickipedia.Application.UseCaseImpl

import com.example.rickipedia.Application.DTOs.CharacterDto
import com.example.rickipedia.Application.UseCase.GetAllCharactersUseCase
import com.example.rickipedia.Infrastructure.Repository.RickAndMortyRepository

/**
 * Implementation of the GetAllCharactersUseCase interface.
 * @param rickAndMortyRepository The repository responsible for fetching characters.
 */
class GetAllCharactersUseCaseImpl(private val rickAndMortyRepository: RickAndMortyRepository) :
    GetAllCharactersUseCase {

    /**
     * Asynchronously retrieves a list of characters using the injected repository.
     * @return A list of CharacterDto representing characters.
     */
    override suspend fun getAllCharacters(): List<CharacterDto> {
        return rickAndMortyRepository.fetchAllCharacters()
    }
}