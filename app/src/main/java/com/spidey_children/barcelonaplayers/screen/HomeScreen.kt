package com.spidey_children.barcelonaplayers.screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.spidey_children.barcelonaplayers.BarcelonaViewModel
import com.spidey_children.barcelonaplayers.navigation.NavGraph

@ExperimentalAnimationApi
@Composable
fun HomeScreen(viewModel: BarcelonaViewModel) {
    val navHostController = rememberNavController()
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "FC バルセロナ 選手一覧") })
    }) {
        NavGraph(navHostController = navHostController, viewModel = viewModel, padding = it)
    }
}