package com.example.applymate.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.applymate.presentation.screens.CoverLetterGeneratorScreen
import com.example.applymate.presentation.screens.DashBoardScreen
import com.example.applymate.presentation.screens.JobSearchScreen
import com.example.applymate.presentation.screens.LinkedInScreen
import com.example.applymate.presentation.screens.ReferralMessageGeneratorScreen
import com.example.applymate.presentation.screens.ResumeOptimizationScreen
import com.example.applymate.presentation.screens.ResumeScreen

@Composable
fun AppNavigator(
    navController: NavHostController = rememberNavController()
) {

    NavHost(
        navController = navController,
        startDestination = Screens.DashBoardScreen.route
    ) {

        composable(
            route = Screens.DashBoardScreen.route
        ){
            DashBoardScreen(navController = navController)
        }

        composable(
            route = Screens.LinkedInScreen.route
        ){
            LinkedInScreen(navController = navController)
        }

        composable(
            route = Screens.ResumeScreen.route
        ){
            ResumeScreen(navController = navController)
        }

        composable(
            route = Screens.ReferralMessageGeneratorScreen.route
        ){
            ReferralMessageGeneratorScreen(navController = navController)
        }

        composable(
            route = Screens.ResumeOptimizationScreen.route
        ){
            ResumeOptimizationScreen(navController = navController)
        }

        composable(
            route = Screens.CoverLetterGeneratorScreen.route
        ){
            CoverLetterGeneratorScreen(navController = navController)
        }

        composable(
            route = Screens.JobSearchScreen.route
        ){
            JobSearchScreen(navController = navController)
        }
    }

}