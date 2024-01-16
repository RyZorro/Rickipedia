package com.example.rickipedia.Application.UseCaseImpl

import com.example.rickipedia.Application.DTOs.CharacterDto
import com.example.rickipedia.Application.UseCase.SearchCharacterUseCase
import com.example.rickipedia.Infrastructure.Repository.RickAndMortyRepository

/**
 * Implementation of the SearchCharacterUseCase interface. Responsible for handling the logic to search for characters from the data source.
 * This class delegates the search functionality to the associated RickAndMortyRepository.
 */
class SearchCharacterUseCaseImpl(private val rickAndMortyRepository: RickAndMortyRepository): SearchCharacterUseCase {

    /**
     * Executes the search for characters based on the provided query.
     *
     * @param query The search query used to filter characters.
     * @return A list of characters matching the search query.
     */
    override suspend fun execute(query: String): List<CharacterDto> {
        return rickAndMortyRepository.searchCharacter(query)
    }
}