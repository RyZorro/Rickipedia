package com.example.rickipedia.Application.DTOs

/**
 * Represents a Data Transfer Object (DTO) for Character information.
 * DTOs are used to transfer data between different layers of an application, providing a lightweight and efficient way to communicate information.
 */
data class CharacterDto(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: OriginDto,
    val location: LocationDto,
    val image: String,
    val episodes: List<String>,
    val url: String,
    val created: String
)