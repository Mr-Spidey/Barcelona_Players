package com.spidey_children.barcelonaplayers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.spidey_children.barcelonaplayers.navigation.SplashNavGraph
import com.spidey_children.barcelonaplayers.ui.theme.BarcelonaPlayersTheme

@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<BarcelonaViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BarcelonaPlayersTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val rootNavHostController = rememberNavController()
                    SplashNavGraph(navHostController = rootNavHostController, viewModel = viewModel)
                }
            }
        }
    }
}



