package com.example.mycleanproject.presentation.navigation

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mycleanproject.presentation.free_game.component.GameScreen
import com.example.mycleanproject.presentation.free_game.state.UiEffect
import com.example.mycleanproject.presentation.free_game.viewmodel.FreeGameViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.GameScreen.route) {
        composable(Screen.GameScreen.route) {
            val freeGameViewModel = hiltViewModel<FreeGameViewModel>()
            val state = freeGameViewModel.freeGameState.collectAsStateWithLifecycle()
            GameScreen(freeGameState = state.value, modifier = Modifier)

            val snackbarHostState = remember {
                SnackbarHostState()
            }
            LaunchedEffect(key1 = true) {
                freeGameViewModel.uiEffect.collectLatest { uiEffect ->
                    when (uiEffect) {
                        UiEffect.NavigateToDetailScreen -> {
                            TODO()
                        }

                        is UiEffect.showSnackbar -> {
                            launch {
                                snackbarHostState.showSnackbar(
                                    uiEffect.msg,
                                    duration = SnackbarDuration.Long
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}