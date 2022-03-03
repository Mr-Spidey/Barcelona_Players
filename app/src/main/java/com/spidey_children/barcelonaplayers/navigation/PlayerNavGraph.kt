package com.spidey_children.barcelonaplayers.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.navigation
import com.spidey_children.barcelonaplayers.BarcelonaViewModel
import com.spidey_children.barcelonaplayers.screen.PlayerDetailScreen
import com.spidey_children.barcelonaplayers.screen.PlayerScreen
import com.spidey_children.barcelonaplayers.screen.Screen

@ExperimentalAnimationApi
fun NavGraphBuilder.playerNavGraph(
    navHostController: NavHostController,
    viewModel: BarcelonaViewModel
) {
    navigation(
        startDestination = Screen.Player.route,
        route = "playerNavGraph",
        enterTransition = null
    ) {
        composable(route = Screen.Player.route, enterTransition = null) {
            viewModel.showTopAndBottomBar = true
            PlayerScreen(viewModel = viewModel, navHostController = navHostController)
        }
        composable(
            route = Screen.PlayerDetail.route + "/{playerName}",
            arguments = listOf(navArgument(name = "playerName") {
                type =
                    NavType.StringType
            }),
            enterTransition = { slideInHorizontally() },
            popExitTransition = { slideOutHorizontally(targetOffsetX = { -it }) }
        ) {
            val playerName = it.arguments?.getString("playerName")
            viewModel.showTopAndBottomBar = false
            PlayerDetailScreen(
                viewModel = viewModel,
                navHostController = navHostController,
                name = playerName.toString()
            )
        }
    }
}