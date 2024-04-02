package com.example.mycleanproject.domain.repositories

import com.example.mycleanproject.core.common.Resource
import com.example.mycleanproject.data.remote.dto.FreeGamesDto
import com.example.mycleanproject.domain.model.FreeGames
import kotlinx.coroutines.flow.Flow

interface FreeGamesRepository {
    fun getFreeGames() : Flow<Resource<List<FreeGames>>>
}