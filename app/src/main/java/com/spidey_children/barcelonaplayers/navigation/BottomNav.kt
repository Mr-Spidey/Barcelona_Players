package com.spidey_children.barcelonaplayers.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.spidey_children.barcelonaplayers.screen.Screen

sealed class BottomNav(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object PlayerBottom :
        BottomNav(route = "playerNavGraph", title = "選手", icon = Icons.Default.Person)

    object InformationBottom :
        BottomNav(route = Screen.Information.route, title = "情報", icon = Icons.Default.Info)
}