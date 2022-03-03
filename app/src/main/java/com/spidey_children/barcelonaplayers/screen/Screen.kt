package com.spidey_children.barcelonaplayers.screen

sealed class Screen(
    val route: String,
    val title: String?
) {
    object Splash : Screen(route = "splash", title = null)
    object Home : Screen(route = "home", title = null)
    object Player : Screen(route = "player", title = "選手一覧")
    object PlayerDetail : Screen(route = "player_detail", title = null)
    object Information : Screen(route = "info", title = "このアプリについて")
}



