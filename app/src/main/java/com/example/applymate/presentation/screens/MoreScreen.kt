package com.example.applymate.presentation.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.applymate.presentation.components.naviagtions.AppScaffold
import com.example.applymate.presentation.components.naviagtions.TopBar
import com.example.applymate.presentation.navigation.BottomNavigatorBar

@Composable
fun MoreScreen(navController: NavHostController) {

    AppScaffold(
        topBar = {
            TopBar(
                title = "More"
            )
        },
        bottomBar = {
            BottomNavigatorBar(navController)
        }
    ) {

        //TODO: Can make this a normal Referral Generator instead of menu

    }

}