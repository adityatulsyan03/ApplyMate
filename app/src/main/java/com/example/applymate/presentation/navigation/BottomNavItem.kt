package com.example.applymate.presentation.navigation

import androidx.navigation.NavController
import com.example.applymate.R
import com.example.applymate.utils.navigateBottomBar
import com.example.applymate.utils.safeNavigateOnce

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
            navController.navigateBottomBar(Screens.HomeScreen.route)
        },
        label = "Home",
        selectedIcon = R.drawable.home_selected,
        unselectedIcon = R.drawable.home_unselected
    )

    data object Jobs : BottomNavItem(
        route = Screens.JobScreen.route,
        onOptionClick = { navController ->
            navController.navigateBottomBar(Screens.JobScreen.route)
        },
        label = "Jobs",
        selectedIcon = R.drawable.jobs_selected,
        unselectedIcon = R.drawable.jobs_unselected
    )

    data object Resume : BottomNavItem(
        route = Screens.ResumeScreen.route,
        onOptionClick = { navController ->
            navController.navigateBottomBar(Screens.ResumeScreen.route)
        },
        label = "Resume",
        selectedIcon = R.drawable.resume_selected,
        unselectedIcon = R.drawable.resume_unselected
    )

    data object Chats : BottomNavItem(
        route = Screens.ChatScreen.route,
        onOptionClick = { navController ->
            navController.navigateBottomBar(Screens.ChatScreen.route)
        },
        label = "Chats",
        selectedIcon = R.drawable.chat_selected,
        unselectedIcon = R.drawable.chat_unselected
    )

    data object Referral : BottomNavItem(
        route = Screens.ReferralScreen.route,
        onOptionClick = { navController ->
            navController.navigateBottomBar(Screens.ReferralScreen.route)
        },
        label = "Referral",
        selectedIcon = R.drawable.referral_selected,
        unselectedIcon = R.drawable.referral_unselected
    )

    companion object {
        val bottomNavOptions = listOf(Home, Jobs, Resume, Chats, Referral)
    }

}