package com.spidey_children.barcelonaplayers.screen

import androidx.compose.animation.*
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.spidey_children.barcelonaplayers.BarcelonaViewModel
import kotlinx.coroutines.delay

@ExperimentalAnimationApi
@Composable
fun SplashScreen(navHostController: NavHostController, viewModel: BarcelonaViewModel) {

    var visible1 by remember { mutableStateOf(false) }
    var visible2 by remember { mutableStateOf(false) }

    val navRouteToHome = Screen.Home.route
    LaunchedEffect(key1 = true) {
        viewModel.getPlayerList()
        visible1 = true
        delay(1000)
        visible2 = true
        delay(1000)
        navHostController.popBackStack()
        navHostController.navigate(navRouteToHome)
    }
    Splash(visible1 = visible1, visible2 = visible2)
}

@ExperimentalAnimationApi
@Composable
fun Splash(visible1: Boolean, visible2: Boolean) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.BottomCenter) {
                this@Column.AnimatedVisibility(
                    visible = visible1,
                    enter = expandHorizontally(
                        expandFrom = Alignment.Start,
                        animationSpec = spring(dampingRatio = 2f, stiffness = Spring.StiffnessLow)
                    )
                ) {
                    Text(
                        text = "Barcelona",
                        modifier = Modifier.padding(16.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = MaterialTheme.typography.h3.fontSize
                    )
                }
            }
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.TopCenter) {
                this@Column.AnimatedVisibility(
                    visible = visible2,
                    enter = expandHorizontally(
                        expandFrom = Alignment.End,
                        animationSpec = spring(dampingRatio = 2f, stiffness = Spring.StiffnessLow)
                    )
                ) {
                    Text(
                        text = "Players",
                        modifier = Modifier.padding(16.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = MaterialTheme.typography.h3.fontSize
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@ExperimentalAnimationApi
@Composable
fun SplashPreview() {
    Splash(visible1 = true, visible2 = true)
}