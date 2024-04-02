package com.example.mycleanproject.presentation.free_game.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.mycleanproject.presentation.free_game.state.FreeGameState

@Composable
fun GameScreen(freeGameState: FreeGameState, modifier: Modifier){
if(freeGameState?.freeGames?.isNotEmpty()!!){
    LazyColumn {
        items(freeGameState.freeGames) {
            FreeGameItem(modifier, it)
        }
    }
}
    else if(freeGameState.isLoading){
        CircularProgressIndicator()
    }
}