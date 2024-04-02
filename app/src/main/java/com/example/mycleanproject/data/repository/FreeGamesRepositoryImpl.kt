package com.example.mycleanproject.data.repository

import com.example.mycleanproject.core.common.Resource
import com.example.mycleanproject.data.FreeGameApiService
import com.example.mycleanproject.data.remote.dto.FreeGamesDto
import com.example.mycleanproject.data.remote.mapper.domainToFreeGames
import com.example.mycleanproject.domain.model.FreeGames
import com.example.mycleanproject.domain.repositories.FreeGamesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher
import javax.inject.Inject

class FreeGamesRepositoryImpl @Inject constructor(private val freeGameApiService: FreeGameApiService) :
    FreeGamesRepository {

    override fun getFreeGames(): Flow<Resource<List<FreeGames>>> = flow {

        emit(Resource.Loading())
        val result = freeGameApiService.getFreeGames().map {
            it.domainToFreeGames()
        }
        emit(Resource.Success(result))
    }.flowOn(Dispatchers.IO)
        .catch { emit(Resource.Error(it.message.toString())) }
}