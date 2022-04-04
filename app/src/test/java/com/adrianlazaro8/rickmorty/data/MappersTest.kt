package com.adrianlazaro8.rickmorty.data

import com.adrianlazaro8.rickmorty.data.dto.CharacterDto
import com.adrianlazaro8.rickmorty.data.dto.EpisodeDto
import com.adrianlazaro8.rickmorty.data.dto.LocationDto
import com.adrianlazaro8.rickmorty.data.dto.OriginDto
import com.adrianlazaro8.rickmorty.domain.*
import org.junit.Assert
import org.junit.Assert.*

import org.junit.Test

class MappersTest {

    @Test
    fun toDomainCharacter() {
        val domainCharacter = characterDto.toDomainCharacter()

        assertTrue(domainCharacter is Character)
    }

    @Test
    fun toDomainLocation() {
        val domainLocation = locationDto.toDomainLocation()

        assertTrue(domainLocation is Location)
    }

    @Test
    fun toDomainEpisode() {
        val domainEpisode = episodeDto.toDomainEpisode()

        assertTrue(domainEpisode is Episode)
    }
}

val characterDto = CharacterDto(
    1,
    "name",
    CharacterStatus.unknown,
    "",
    "",
    "",
    OriginDto("", ""),
    LocationDto(1, "", "", "", listOf(), ""),
    "",
    listOf(),
    "",
    ""
)

val locationDto = LocationDto(
    1,
    "",
    "",
    "",
    listOf(),
    ""
)

val episodeDto = EpisodeDto(
    1,
    "",
    "",
    "",
    listOf(),
    "",
    ""
)