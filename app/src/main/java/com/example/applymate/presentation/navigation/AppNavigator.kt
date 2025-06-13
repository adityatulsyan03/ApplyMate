package com.example.applymate.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.applymate.presentation.screens.ChatScreen
import com.example.applymate.presentation.screens.HomeScreen
import com.example.applymate.presentation.screens.JobScreen
import com.example.applymate.presentation.screens.ReferralScreen
import com.example.applymate.presentation.screens.ResumeScreen

@Composable
fun AppNavigator(
    navController: NavHostController = rememberNavController()
) {

    NavHost(
        navController = navController,
        startDestination = Screens.HomeScreen.route
    ) {

        composable(
            route = Screens.HomeScreen.route
        ){
            HomeScreen(navController = navController)
        }

        composable(
            route = Screens.JobScreen.route
        ){
            JobScreen(navController = navController)
        }

        composable(
            route = Screens.ResumeScreen.route
        ){
            ResumeScreen(navController = navController)
        }

        composable(
            route = Screens.ChatScreen.route
        ){
            ChatScreen(navController = navController)
        }

        composable(
            route = Screens.ReferralScreen.route
        ){
            ReferralScreen(navController = navController)
        }
    }

}