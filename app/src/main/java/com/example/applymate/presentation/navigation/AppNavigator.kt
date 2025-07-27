package com.example.applymate.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.applymate.presentation.screens.ChatScreen
import com.example.applymate.presentation.screens.HomeScreen
import com.example.applymate.presentation.screens.JobScreen
import com.example.applymate.presentation.screens.ReferralScreen
import com.example.applymate.presentation.screens.ResumeScreen
import com.example.applymate.presentation.viewModel.ActivityViewModel
import com.example.applymate.presentation.viewModel.ChatViewModel
import com.example.applymate.presentation.viewModel.DocumentViewModel
import com.example.applymate.presentation.viewModel.JobSearchViewModel
import com.example.applymate.presentation.viewModel.ReferralViewModel
import com.example.applymate.presentation.viewModel.ResumeViewModel

@Composable
fun AppNavigator(
    navController: NavHostController = rememberNavController()
) {

    val activityViewModel: ActivityViewModel = hiltViewModel()
    val chatViewModel: ChatViewModel = hiltViewModel()
    val documentViewModel: DocumentViewModel = hiltViewModel()
    val jobSearchViewModel: JobSearchViewModel = hiltViewModel()
    val referralViewModel: ReferralViewModel = hiltViewModel()
    val resumeViewModel: ResumeViewModel = hiltViewModel()

    NavHost(
        navController = navController,
        startDestination = Screens.HomeScreen.route
    ) {

        composable(
            route = Screens.HomeScreen.route
        ){
            HomeScreen(
                navController = navController,
                viewModel = activityViewModel
            )
        }

        composable(
            route = Screens.JobScreen.route
        ){
            JobScreen(
                navController = navController,
                viewModel = jobSearchViewModel,
                activityViewModel = activityViewModel
            )
        }

        composable(
            route = Screens.ResumeScreen.route
        ){
            ResumeScreen(
                navController = navController,
                viewModel = resumeViewModel,
                documentViewModel = documentViewModel,
                activityViewModel = activityViewModel
            )
        }

        composable(
            route = Screens.ChatScreen.route
        ){
            ChatScreen(
                navController = navController,
                viewModel = chatViewModel,
                documentViewModel = documentViewModel,
                activityViewModel = activityViewModel
            )
        }

        composable(
            route = Screens.ReferralScreen.route
        ){
            ReferralScreen(
                navController = navController,
                viewModel = referralViewModel,
                activityViewModel = activityViewModel
            )
        }
    }

}