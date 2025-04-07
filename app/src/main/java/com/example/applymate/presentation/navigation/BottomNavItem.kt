package com.example.applymate.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import com.example.applymate.R

sealed class BottomNavItem(
    val route: String,
    val onOptionClick: (NavController) -> Unit,
    val label:  String,
    val selectedIcon: NavIcon,
    val unselectedIcon: NavIcon
){

    data object DashBoard: BottomNavItem(
        route = Screens.DashBoardScreen.route,
        onOptionClick = { navController ->
            navController.navigate(Screens.DashBoardScreen.route){
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
        },
        label = "Home",
        selectedIcon = NavIcon.Vector(Icons.Filled.Home),
        unselectedIcon = NavIcon.Vector(Icons.Outlined.Home)
    )

    data object LinkedIn: BottomNavItem(
        route = Screens.LinkedInScreen.route,
        onOptionClick = { navController ->
            navController.navigate(Screens.LinkedInScreen.route){
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
        },
        label = "LinkedIn",
        //Here
        selectedIcon = NavIcon.Drawable(R.drawable.linkedin_filled),
        unselectedIcon = NavIcon.Drawable(R.drawable.linkedin_outline)
    )

    data object Resume: BottomNavItem(
        route = Screens.ResumeScreen.route,
        onOptionClick = { navController ->
            navController.navigate(Screens.ResumeScreen.route){
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
        },
        label = "Resume",
        selectedIcon = NavIcon.Drawable(R.drawable.resume_filled),
        unselectedIcon = NavIcon.Drawable(R.drawable.resume_outline)
    )

    companion object {
        val bottomNavOptions = listOf(DashBoard, LinkedIn, Resume)
    }

}

sealed class NavIcon {
    data class Vector(val icon: ImageVector) : NavIcon()
    data class Drawable(val resId: Int) : NavIcon()
}