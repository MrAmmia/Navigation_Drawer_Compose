package net.thebookofcode.www.navigation_drawer_compose.screens.main_screen

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import net.thebookofcode.www.navigation_drawer_compose.R

@Composable
fun AppBar(
    onNavigationItemClick: () -> Unit,
    drawerState: DrawerState
) {
    TopAppBar(
        title = {
            Text(text = stringResource(id = R.string.app_name))
        },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary,
        navigationIcon = {
            IconButton(onClick = onNavigationItemClick) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = if (drawerState.isOpen) {
                        stringResource(id = R.string.opened_drawer)
                    } else {
                        stringResource(id = R.string.closed_drawer)
                    }
                )
            }
        }
    )
}