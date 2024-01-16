package com.example.rickipedia.Domain.Entities

import com.example.rickipedia.Domain.ValueObjects.EpisodeUrl
import com.example.rickipedia.Domain.ValueObjects.Location
import com.example.rickipedia.Domain.ValueObjects.Origin

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Origin,
    val location: Location,
    val image: String,
    val episodes: List<EpisodeUrl>,
    val url: String,
    val created: String
)