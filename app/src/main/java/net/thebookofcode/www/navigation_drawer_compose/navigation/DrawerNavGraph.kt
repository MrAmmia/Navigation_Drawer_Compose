package net.thebookofcode.www.navigation_drawer_compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import net.thebookofcode.www.navigation_drawer_compose.screens.ScreenContent

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = MenuItem.Home.route
    ) {
        composable(route = MenuItem.Home.route) {
            ScreenContent(name = MenuItem.Home.title)
        }
        composable(route = MenuItem.Profile.route) {
            ScreenContent(name = MenuItem.Profile.title)
        }
        composable(route = MenuItem.Settings.route) {
            ScreenContent(name = MenuItem.Settings.title)
        }
    }
}