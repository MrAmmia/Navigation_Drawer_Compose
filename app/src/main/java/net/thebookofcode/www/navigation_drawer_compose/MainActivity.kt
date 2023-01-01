package net.thebookofcode.www.navigation_drawer_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.rememberScaffoldState
import androidx.navigation.compose.rememberNavController
import net.thebookofcode.www.navigation_drawer_compose.screens.main_screen.MainScreen
import net.thebookofcode.www.navigation_drawer_compose.ui.theme.Navigation_Drawer_ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation_Drawer_ComposeTheme {
                // A surface container using the 'background' color from the theme
                MainScreen(
                    scaffoldState = rememberScaffoldState(),
                    navController = rememberNavController()
                )
            }
        }
    }
}

