package com.example.rickipedia.Application.Wrapper

/**
 * Interface defining a contract for wrapping objects of type T.
 * This interface adheres to Domain-Driven Design principles by providing a clear abstraction for object wrapping within the application layer.
 * It follows SOLID principles by focusing on a single responsibility, allowing flexibility in wrapping behaviors for different object types.
 */
interface CharacterWrapper<T> {

    /**
     * Wraps an object of type T.
     * @param character The object to be wrapped.
     * @return The wrapped object of type T.
     */
    fun wrap(characterDto: T): T
}