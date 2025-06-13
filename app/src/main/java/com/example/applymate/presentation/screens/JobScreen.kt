package com.example.applymate.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.applymate.presentation.components.core.Header
import com.example.applymate.presentation.components.jobSearch.FindJobs
import com.example.applymate.presentation.components.jobSearch.JobSearchFilter
import com.example.applymate.presentation.components.naviagtions.AppScaffold
import com.example.applymate.presentation.components.naviagtions.TopBar
import com.example.applymate.presentation.navigation.BottomNavigatorBar

@Composable
fun JobScreen(navController: NavHostController) {

    AppScaffold(
        bottomBar = {
            BottomNavigatorBar(navController)
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                LazyColumn(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    contentPadding = PaddingValues(bottom = 80.dp)
                ) {
                    item {
                        Header(
                            first = "Smart Job Finder",
                            second = "Find relevant jobs on LinkedIn"
                        )
                    }
                    item { JobSearchFilter() }
                }
                FindJobs(modifier = Modifier.align(Alignment.BottomCenter))
            }
        }
    }

}