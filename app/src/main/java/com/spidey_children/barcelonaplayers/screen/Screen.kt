package com.spidey_children.barcelonaplayers.screen

sealed class Screen(
    val route: String
) {
    object Splash : Screen(route = "splash")
    object Home : Screen(route = "home")
    object Player: Screen(route = "player")
}
