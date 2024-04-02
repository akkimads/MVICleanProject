package com.example.mycleanproject.presentation.free_game.state

import com.example.mycleanproject.core.common.Resource
import com.example.mycleanproject.domain.model.FreeGames

data class FreeGameState(
    val freeGames: List<FreeGames>? = emptyList(),
    val errorMsg : String? = null,
    val isLoading: Boolean = false
    )
