package com.example.applymate.presentation.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.applymate.common.UiState
import com.example.applymate.presentation.components.core.Header
import com.example.applymate.presentation.components.dashboard.QuickAction
import com.example.applymate.presentation.components.dashboard.RecentActivities
import com.example.applymate.presentation.components.naviagtions.AppScaffold
import com.example.applymate.presentation.navigation.BottomNavigatorBar
import com.example.applymate.presentation.viewModel.ActivityViewModel
import com.example.applymate.ui.theme.ApplyMateTheme
import com.example.applymate.utils.safePopBackStack

@Composable
fun HomeScreen(navController: NavHostController, viewModel: ActivityViewModel) {

    val homeScreenState by remember { mutableStateOf(UiState.Idle) }

    BackHandler {
        navController.safePopBackStack()
    }

    ApplyMateTheme {
        AppScaffold(
            bottomBar = {
                BottomNavigatorBar(navController)
            }
        ) {
            if(homeScreenState == UiState.Idle){
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        item {
                            Header(
                                first = "Good Morning, User",
                                second = "Let's find your dream job today"
                            )
                        }
                        //TODO: An option to enter your own AI API Key
                        item {
                            RecentActivities(
                                navController = navController,
                                viewModel = viewModel,
                                homeScreenState = homeScreenState
                            )
                        }
                        item { QuickAction(navController = navController) }
                    }
                }
            }
        }
    }
}