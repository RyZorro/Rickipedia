package com.example.rickipedia.Application.Mapper

import com.example.rickipedia.Application.DTOs.CharacterDto
import com.example.rickipedia.Domain.Entities.Character

/**
 * Interface defining a contract for mapping a Character domain entity to a CharacterDto data transfer object (DTO).
 * This interface adheres to Domain-Driven Design principles by separating concerns related to domain entity-to-DTO mapping.
 * It follows SOLID principles by focusing on a single responsibility and abstraction.
 */
interface CharacterMapper {
    /**
     * Converts a Character domain entity to a CharacterDto data transfer object.
     *
     * @param character The Character domain entity to be mapped.
     * @return The mapped CharacterDto data transfer object.
     */
    fun toDto(character: Character): CharacterDto
}