package com.example.mycleanproject.data.remote.mapper

import com.example.mycleanproject.data.remote.dto.FreeGamesDto
import com.example.mycleanproject.domain.model.FreeGames

fun FreeGamesDto.domainToFreeGames() : FreeGames {
    return FreeGames(game_url,id, shortDescription,thumbnail, title)
}