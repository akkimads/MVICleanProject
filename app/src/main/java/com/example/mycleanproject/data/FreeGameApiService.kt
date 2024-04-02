package com.example.mycleanproject.data

import com.example.mycleanproject.data.remote.dto.FreeGamesDto
import retrofit2.http.GET

interface FreeGameApiService {
    @GET("games")
    suspend fun getFreeGames() : List<FreeGamesDto>
}