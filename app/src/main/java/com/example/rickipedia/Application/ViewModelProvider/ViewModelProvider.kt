package com.example.rickipedia.Application.ViewModelProvider

import com.example.rickipedia.Presentation.ViewModels.CharacterDetailViewModel
import com.example.rickipedia.Presentation.ViewModels.CharacterListViewModel

/**
 * Interface defining methods to provide various ViewModels related to the Rick and Morty feature.
 * It adheres to Dependency Inversion Principle (DIP) by abstracting ViewModel creation.
 */
interface ViewModelProvider {

    /**
     * Provides an instance of CharacterListViewModel.
     * @return CharacterListViewModel instance.
     */
    fun provideCharacterListViewModel(): CharacterListViewModel
    fun provideCharacterDetailViewModel(): CharacterDetailViewModel
}