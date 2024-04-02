package com.example.mycleanproject.presentation.navigation

sealed class Screen(val route: String) {
    object GameScreen : Screen("game_screen")
}