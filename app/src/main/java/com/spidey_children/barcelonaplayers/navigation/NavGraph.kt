package com.spidey_children.barcelonaplayers.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.spidey_children.barcelonaplayers.BarcelonaViewModel
import com.spidey_children.barcelonaplayers.screen.InformationScreen
import com.spidey_children.barcelonaplayers.screen.Screen

@ExperimentalAnimationApi
@Composable
fun NavGraph(
    navHostController: NavHostController,
    viewModel: BarcelonaViewModel,
    padding: PaddingValues
) {
    AnimatedNavHost(
        navController = navHostController,
        startDestination = BottomNav.PlayerBottom.route,
        modifier = Modifier.padding(padding)
    ) {
        playerNavGraph(viewModel = viewModel, navHostController = navHostController)
        composable(route = Screen.Information.route, enterTransition = null) { InformationScreen(padding = padding) }
    }
}

