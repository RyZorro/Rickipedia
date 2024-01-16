package com.example.rickipedia.Application.Mapper

import com.example.rickipedia.Application.DTOs.CharacterDto
import com.example.rickipedia.Domain.ValueObjects.Location
import com.example.rickipedia.Domain.ValueObjects.Origin
import com.example.rickipedia.Domain.Entities.Character
import com.example.rickipedia.Application.DTOs.LocationDto
import com.example.rickipedia.Application.DTOs.OriginDto

/**
 * Implementation of the CharacterMapper interface, responsible for mapping a Character domain entity to a CharacterDto data transfer object (DTO).
 * This class adheres to Domain-Driven Design principles by encapsulating the mapping logic within the application layer.
 * It follows SOLID principles by having a single responsibility for character-to-DTO mapping and utilizing abstractions for location and origin mapping.
 */
/**
 * Implementation of the CharacterMapper interface, responsible for mapping a Character domain entity to a CharacterDto data transfer object (DTO).
 * This class adheres to Domain-Driven Design principles by encapsulating the mapping logic within the application layer.
 * It follows SOLID principles by having a single responsibility for character-to-DTO mapping and utilizing abstractions for location and origin mapping.
 */
object CharacterMapperImpl : CharacterMapper {

    /**
     * Converts a Character domain entity to a CharacterDto data transfer object.
     *
     * @param character The Character domain entity to be mapped.
     * @return The mapped CharacterDto data transfer object.
     */
    override fun toDto(character: Character): CharacterDto {
        try {
            println("Character: $character")

            val characterDto = CharacterDto(
                id = character.id,
                name = character.name ?: "",
                status = character.status ?: "",
                species = character.species ?: "",
                type = character.type ?: "",
                gender = character.gender ?: "",
                origin = toOriginDto(character.origin),
                location = toLocationDto(character.location),
                image = character.image ?: "",
                episodes = character.episodes.orEmpty().mapNotNull { it?.value ?: "" },
                url = character.url ?: "",
                created = character.created ?: ""
            )

            println("CharacterDto: $characterDto")

            return characterDto
        } catch (e: Exception) {
            println("Error in toDto: ${e.message}")
            throw e
        }
    }

    /**
     * Converts an Origin domain value object to an OriginDto data transfer object.
     *
     * @param origin The Origin domain value object to be mapped.
     * @return The mapped OriginDto data transfer object.
     */
    private fun toOriginDto(origin: Origin?): OriginDto {
        return OriginDto(
            name = origin?.name ?: "",
            url = origin?.url ?: ""
        )
    }

    /**
     * Converts a Location domain value object to a LocationDto data transfer object.
     *
     * @param location The Location domain value object to be mapped.
     * @return The mapped LocationDto data transfer object.
     */
    private fun toLocationDto(location: Location?): LocationDto {
        return LocationDto(
            name = location?.name ?: "",
            url = location?.url ?: ""
        )
    }
}