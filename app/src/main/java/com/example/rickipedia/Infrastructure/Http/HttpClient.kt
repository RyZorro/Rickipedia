package com.example.rickipedia.Infrastructure.Http

import com.example.rickipedia.Infrastructure.ExternalService.RickAndMortyApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * It provides a single instance of Retrofit configured with the base URL and Gson converter factory.
 * The lazy initialization ensures that the Retrofit instance is created only when accessed for the first time.
 * The service property exposes the API interface for making network requests.
 */
object HttpClient {

    // Base URL for the Rick and Morty API
    private const val BASE_URL = "https://rickandmortyapi.com/api/"

    // Lazy-initialized Retrofit instance with Gson converter factory
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Exposes the API interface for making network requests
    val service: RickAndMortyApi by lazy {
        retrofit.create(RickAndMortyApi::class.java)
    }
}