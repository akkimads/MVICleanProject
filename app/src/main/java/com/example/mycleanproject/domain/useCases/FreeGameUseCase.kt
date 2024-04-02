package com.example.mycleanproject.domain.useCases

import com.example.mycleanproject.domain.repositories.FreeGamesRepository
import javax.inject.Inject

class FreeGameUseCase @Inject constructor(private val repository: FreeGamesRepository) {
    operator fun invoke() = repository.getFreeGames()
}