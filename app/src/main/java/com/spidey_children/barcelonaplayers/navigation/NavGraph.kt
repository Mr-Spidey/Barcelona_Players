package com.spidey_children.barcelonaplayers.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.spidey_children.barcelonaplayers.BarcelonaViewModel

@Composable
fun NavGraph(
    navHostController: NavHostController,
    viewModel: BarcelonaViewModel,
    padding: PaddingValues
) {
    NavHost(
        navController = navHostController,
        startDestination = "playerNavGraph",
        modifier = Modifier.padding(padding)
    ) {
        playerNavGraph(viewModel = viewModel)
    }
}