package com.spidey_children.barcelonaplayers.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.spidey_children.barcelonaplayers.BarcelonaViewModel
import com.spidey_children.barcelonaplayers.screen.HomeScreen
import com.spidey_children.barcelonaplayers.screen.Screen
import com.spidey_children.barcelonaplayers.screen.SplashScreen

@ExperimentalAnimationApi
@Composable
fun SplashNavGraph(
    navHostController: NavHostController,
    viewModel: BarcelonaViewModel
) {
    NavHost(navController = navHostController, startDestination = Screen.Splash.route) {
        composable(route = Screen.Splash.route) {
            SplashScreen(
                navHostController = navHostController,
                viewModel = viewModel
            )
        }
        composable(route = Screen.Home.route) {
            HomeScreen(viewModel = viewModel)
        }
    }
}