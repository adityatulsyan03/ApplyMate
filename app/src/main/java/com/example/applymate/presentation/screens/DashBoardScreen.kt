package com.example.applymate.presentation.screens

import android.net.Uri
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.applymate.R
import com.example.applymate.common.iconInfoMapByIcon
import com.example.applymate.presentation.components.core.Header
import com.example.applymate.presentation.components.dashboard.HomeSearchFilter
import com.example.applymate.presentation.components.dashboard.QuickAction
import com.example.applymate.presentation.components.dashboard.RecentActivities
import com.example.applymate.presentation.components.naviagtions.AppScaffold
import com.example.applymate.presentation.navigation.BottomNavigatorBar
import com.example.applymate.ui.theme.ApplyMateTheme
import com.example.applymate.utils.dashedBorder
import com.example.applymate.utils.safePopBackStack

@Composable
fun HomeScreen(navController: NavHostController) {

    BackHandler {
        navController.safePopBackStack()
    }

    ApplyMateTheme {
        AppScaffold(
            bottomBar = {
                BottomNavigatorBar(navController)
            }
        ) {
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
                    //TODO: Can remove this and give an option to enter your own AI API Key
                    item { HomeSearchFilter() }
                    item { RecentActivities(navController = navController) }
                    item { QuickAction(navController = navController) }
                }
            }
        }
    }
}