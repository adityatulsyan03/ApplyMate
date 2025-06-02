package com.example.applymate.presentation.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigatorBar(navController: NavController) {
    NavigationBar {
        val backStackEntry = navController.currentBackStackEntryAsState()
        for(option in BottomNavItem.bottomNavOptions){
            val selected = option.route == backStackEntry.value?.destination?.route
            NavigationBarItem(
                selected = selected,
                onClick = { option.onOptionClick(navController) },
                icon = {
                    val currentIcon = if (selected) {
                        option.selectedIcon
                    } else {
                        option.unselectedIcon
                    }
                    Icon(
                        painter = painterResource(id = currentIcon),
                        contentDescription = "",
                        tint = Color.Unspecified
                    )
                },
                label = { Text(option.label) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    selectedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    indicatorColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    }
}