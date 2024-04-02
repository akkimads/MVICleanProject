package com.example.mycleanproject.domain.model

data class FreeGames(
    val game_url: String,
    val id: Int,
    val shortDescription: String,
    val thumbnail: String,
    val title: String
)