package com.spidey_children.barcelonaplayers.screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Sort
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.spidey_children.barcelonaplayers.BarcelonaViewModel
import com.spidey_children.barcelonaplayers.navigation.BottomNav
import com.spidey_children.barcelonaplayers.navigation.NavGraph

@ExperimentalAnimationApi
@Composable
fun HomeScreen(viewModel: BarcelonaViewModel) {
    val bottomNavItem = listOf(
        BottomNav.PlayerBottom,
        BottomNav.InformationBottom
    )
    val navHostController = rememberAnimatedNavController()
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    Scaffold(
        topBar = {
            if (viewModel.showTopAndBottomBar) {
                if (currentDestination?.route == Screen.Player.route) {
                    TopAppBar(title = { Text(text = Screen.Player.title.toString()) },
                        actions = {
                            DropDownMenuFunction(viewModel = viewModel)
                        })
                } else {
                    TopAppBar(title = { Text(text = Screen.Information.title.toString()) })
                }
            }
        },
        bottomBar = {
            if (viewModel.showTopAndBottomBar) {
                BottomNavigation {
                    bottomNavItem.forEach { screen ->
                        BottomNavigationItem(
                            label = { Text(text = screen.title) },
                            selected = currentDestination?.hierarchy?.any {
                                it.route == screen.route
                            } == true,
                            unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
                            onClick = {
                                navHostController.navigate(screen.route) {
                                    launchSingleTop = true
                                    restoreState = true
                                    popUpTo(0) {
                                        saveState = true
                                    }
                                }
                            },
                            icon = { Icon(screen.icon, contentDescription = null) }
                        )
                    }
                }
            }
        }
    ) {
        Box(modifier = Modifier.wrapContentSize(), contentAlignment = Alignment.TopEnd) {

        }
        NavGraph(navHostController = navHostController, viewModel = viewModel, padding = it)
    }
}

@Composable
fun DropDownMenuFunction(viewModel: BarcelonaViewModel) {
    var dropdownExpanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier.wrapContentSize(Alignment.TopEnd)) {
        IconButton(onClick = { dropdownExpanded = true }) {
            Icon(imageVector = Icons.Default.Sort, contentDescription = "")
        }
        DropdownMenu(
            expanded = dropdownExpanded,
            onDismissRequest = { dropdownExpanded = false }
        ) {
            DropdownMenuItem(onClick = { viewModel.sortPlayerListFlag = 0 }) {
                Text(text = "ポジション順に並べ替え")
            }
            Divider()
            DropdownMenuItem(onClick = { viewModel.sortPlayerListFlag = 1 }) {
                Text(text = "背番号順に並べ替え")
            }
            Divider()
            DropdownMenuItem(onClick = { viewModel.sortPlayerListFlag = 2 }) {
                Text(text = "五十音順に並べ替え")
            }
        }
    }
}




