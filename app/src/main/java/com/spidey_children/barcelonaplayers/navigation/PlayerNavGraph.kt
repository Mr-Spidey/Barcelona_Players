package com.spidey_children.barcelonaplayers.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.spidey_children.barcelonaplayers.BarcelonaViewModel
import com.spidey_children.barcelonaplayers.screen.PlayerScreen
import com.spidey_children.barcelonaplayers.screen.Screen

fun NavGraphBuilder.playerNavGraph(
    navHostController: NavHostController,
    viewModel: BarcelonaViewModel
){
    navigation(startDestination = Screen.Player.route, route = "playerNavGraph"){
        composable(route = Screen.Player.route){
            PlayerScreen(viewModel = viewModel)
        }
    }
}