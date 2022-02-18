package com.adrianlazaro8.rickmorty.data

import com.adrianlazaro8.rickmorty.data.dto.CharacterDto
import com.adrianlazaro8.rickmorty.domain.Character

fun List<CharacterDto>.toDomainCharacterList() = map { it.toDomainCharacter() }

fun CharacterDto.toDomainCharacter(): Character {
    return Character(
        id = id,
        name = name,
        status = status,
        gender = gender,
        origin = origin,
        location = location,
        image = image,
        episode = episode,
        url = url
    )
}