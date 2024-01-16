package com.example.rickipedia.Application.Wrapper

import com.example.rickipedia.Application.DTOs.CharacterDto

/**
 * Implementation of the CharacterWrapper interface for wrapping CharacterDto objects.
 * This class adheres to Domain-Driven Design principles by encapsulating the wrapping logic for CharacterDto objects within the application layer.
 * It follows SOLID principles by having a single responsibility for wrapping CharacterDto objects and allowing for additional wrapping logic if needed.
 */
class CharacterWrapperImpl : CharacterWrapper<CharacterDto> {

    /**
     * Wraps a CharacterDto object.
     * @param character The CharacterDto object to be wrapped.
     * @return The wrapped CharacterDto object.
     */
    override fun wrap(characterDto: CharacterDto): CharacterDto {
        return characterDto
    }
}