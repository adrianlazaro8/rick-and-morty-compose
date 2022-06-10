package com.adrianlazaro8.rickmorty.data.mappers

import com.adrianlazaro8.rickmorty.data.dto.OriginDto
import com.adrianlazaro8.rickmorty.domain.Origin

fun OriginDto.toDomainOrigin(): Origin {
    return Origin(
        name = name,
        url = url
    )
}