package com.example.mycleanproject.presentation.free_game.state

sealed class UiEffect {
    class showSnackbar(val msg : String) : UiEffect()
    object NavigateToDetailScreen : UiEffect()
}