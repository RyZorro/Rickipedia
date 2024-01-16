package com.example.rickipedia.Application.ViewModelProvider

import com.example.rickipedia.Application.DTOs.CharacterDto
import com.example.rickipedia.Application.Mapper.CharacterMapper
import com.example.rickipedia.Application.Mapper.CharacterMapperImpl
import com.example.rickipedia.Application.UseCaseImpl.GetAllCharactersUseCaseImpl
import com.example.rickipedia.Application.UseCaseImpl.GetCharacterByIdUseCaseImpl
import com.example.rickipedia.Application.UseCaseImpl.SearchCharacterUseCaseImpl
import com.example.rickipedia.Application.Wrapper.CharacterWrapper
import com.example.rickipedia.Application.Wrapper.CharacterWrapperImpl
import com.example.rickipedia.Infrastructure.Http.HttpClient
import com.example.rickipedia.Infrastructure.Repository.RickAndMortyRepository
import com.example.rickipedia.Presentation.ViewModels.CharacterDetailViewModel
import com.example.rickipedia.Presentation.ViewModels.CharacterListViewModel

/**
 * Implementation of the ViewModelProvider interface, responsible for providing various ViewModels.
 * This class adheres to Dependency Inversion Principle (DIP) and encapsulates the initialization of services, mappers,
 * and use cases for the Rick and Morty feature within the application.
 */
class ViewModelProviderImpl : ViewModelProvider {

    // Api
    private val apiService = try {
        HttpClient.service
    } catch (e: Exception) {
        throw RuntimeException("Failed to initialize RickAndMortyApiService", e)
    }

    // Mapper and Wrapper
    private val characterMapper: CharacterMapper = CharacterMapperImpl
    private val characterWrapper: CharacterWrapper<CharacterDto> = CharacterWrapperImpl()

    // Repository
    private val repository = RickAndMortyRepository(apiService, characterMapper, characterWrapper)

    // Use Cases
    private val getAllCharactersUseCase = GetAllCharactersUseCaseImpl(repository)
    private val searchCharacterUseCase = SearchCharacterUseCaseImpl(repository)
    private val getCharacterByIdUseCase = GetCharacterByIdUseCaseImpl(repository)

    /**
     * Provides an instance of CharacterListViewModel.
     * @return CharacterListViewModel instance.
     */
    override fun provideCharacterListViewModel(): CharacterListViewModel {
        return CharacterListViewModel(getAllCharactersUseCase,searchCharacterUseCase)
    }

    /**
     * Provides an instance of CharacterDetailViewModel.
     * @return CharacterDetailViewModel instance.
     */
    override fun provideCharacterDetailViewModel(): CharacterDetailViewModel {
        return CharacterDetailViewModel(getCharacterByIdUseCase)
    }
}