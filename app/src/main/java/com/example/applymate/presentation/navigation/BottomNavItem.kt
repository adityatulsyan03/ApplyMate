package com.example.applymate.presentation.navigation

import androidx.navigation.NavController
import com.example.applymate.R

sealed class BottomNavItem(
    val route: String,
    val onOptionClick: (NavController) -> Unit,
    val label: String,
    val selectedIcon: Int,
    val unselectedIcon: Int
) {

    data object Home : BottomNavItem(
        route = Screens.HomeScreen.route,
        onOptionClick = { navController ->
            navController.navigate(Screens.HomeScreen.route) {
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
        },
        label = "Home",
        selectedIcon = R.drawable.home_selected,
        unselectedIcon = R.drawable.home_unselected
    )

    data object Jobs : BottomNavItem(
        route = Screens.JobScreen.route,
        onOptionClick = { navController ->
            navController.navigate(Screens.JobScreen.route) {
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
        },
        label = "Jobs",
        selectedIcon = R.drawable.jobs_selected,
        unselectedIcon = R.drawable.jobs_unselected
    )

    data object Resume : BottomNavItem(
        route = Screens.ResumeScreen.route,
        onOptionClick = { navController ->
            navController.navigate(Screens.ResumeScreen.route) {
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
        },
        label = "Resume",
        selectedIcon = R.drawable.resume_selected,
        unselectedIcon = R.drawable.resume_unselected
    )

    data object Chats : BottomNavItem(
        route = Screens.ChatScreen.route,
        onOptionClick = { navController ->
            navController.navigate(Screens.ChatScreen.route) {
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
        },
        label = "Chats",
        selectedIcon = R.drawable.chat_selected,
        unselectedIcon = R.drawable.chat_unselected
    )

    data object More : BottomNavItem(
        route = Screens.MoreScreen.route,
        onOptionClick = { navController ->
            navController.navigate(Screens.MoreScreen.route) {
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
        },
        label = "More",
        selectedIcon = R.drawable.more_selected,
        unselectedIcon = R.drawable.more_unselected
    )

    companion object {
        val bottomNavOptions = listOf(Home, Jobs, Resume, Chats, More)
    }

}