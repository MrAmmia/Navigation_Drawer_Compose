package net.thebookofcode.www.navigation_drawer_compose.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class MenuItem(
    val id: String,
    val title: String,
    val description: String,
    val icon: ImageVector,
    val route: String = ""
) {
    object Home : MenuItem(
        id = "home",
        title = "Home",
        description = "Home Screen",
        icon = Icons.Default.Home,
        route = "HOME_SCREEN"
    )

    object Profile : MenuItem(
        id = "profile",
        title = "Profile",
        description = "Profile Screen",
        icon = Icons.Default.Person,
        route = "PROFILE_SCREEN"
    )

    object Settings : MenuItem(
        id = "settings",
        title = "Settings",
        description = "Settings Screen",
        icon = Icons.Default.Settings,
        route = "SETTINGS_SCREEN"
    )

    object Help : MenuItem(
        id = "help",
        title = "Help",
        description = "Help Button",
        icon = Icons.Default.Info
    )

    object RateUs : MenuItem(
        id = "rate_us",
        title = "Rate Us",
        description = "Rate Us",
        icon = Icons.Default.Star
    )
}