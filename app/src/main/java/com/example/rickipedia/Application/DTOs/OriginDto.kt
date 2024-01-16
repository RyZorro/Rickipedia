package com.example.rickipedia.Application.DTOs

/**
 * Represents a Data Transfer Object (DTO) for Character information.
 * DTOs are used to transfer data between different layers of an application, providing a lightweight and efficient way to communicate information.
 */
data class OriginDto(
    val name: String,
    val url: String
)