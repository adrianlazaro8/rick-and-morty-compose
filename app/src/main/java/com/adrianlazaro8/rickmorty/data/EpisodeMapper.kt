package com.adrianlazaro8.rickmorty.data

import com.adrianlazaro8.rickmorty.data.dto.EpisodeDto
import com.adrianlazaro8.rickmorty.domain.Episode

fun EpisodeDto.toDomainEpisode() =
    Episode(
        id = this.id,
        name = this.name,
        airDate = this.airDate,
        episode = this.episode,
        characters = this.characters,
        url = this.url,
        created = this.created
    )