package net.thebookofcode.www.navigation_drawer_compose.screens.main_screen

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch
import net.thebookofcode.www.navigation_drawer_compose.navigation.MenuItem
import net.thebookofcode.www.navigation_drawer_compose.navigation.SetupNavGraph

@Composable
fun MainScreen(
    scaffoldState: ScaffoldState,
    navController:NavHostController
) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val intent = remember{Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))}
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppBar(
                onNavigationItemClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                },
                drawerState = scaffoldState.drawerState
            )
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerElevation = 8.dp,
        drawerContent = {
            // This is for the header where profile and the likes go
            // DrawerHeader()
            DrawerBody(items = listOf(
                MenuItem.Home,
                MenuItem.Profile,
                MenuItem.Settings,
                MenuItem.Help,
                MenuItem.RateUs
            ),
                onItemClick = { menuItem ->
                    when (menuItem.id) {
                        "help" -> context.startActivity(intent)

                        "rate_us" -> context.startActivity(intent)

                        else -> {
                            navController.navigate(menuItem.route){
                                popUpTo(navController.graph.findStartDestination().id)
                                launchSingleTop = true
                            }
                        }
                    }
                    scope.launch {
                        scaffoldState.drawerState.close()
                    }

                }
            )
        }
    ){
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            SetupNavGraph(navController = navController)
        }
    }
}