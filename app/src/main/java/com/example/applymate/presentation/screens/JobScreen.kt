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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.applymate.common.UiState
import com.example.applymate.data.model.CustomResponse
import com.example.applymate.presentation.components.core.Header
import com.example.applymate.presentation.components.jobSearch.FindJobs
import com.example.applymate.presentation.components.jobSearch.JobSearchFilter
import com.example.applymate.presentation.components.naviagtions.AppScaffold
import com.example.applymate.presentation.navigation.BottomNavigatorBar
import com.example.applymate.presentation.viewModel.ActivityViewModel
import com.example.applymate.presentation.viewModel.JobSearchViewModel
import com.example.applymate.utils.openLinkedInJobSearch

@Composable
fun JobScreen(
    navController: NavHostController,
    viewModel: JobSearchViewModel,
    activityViewModel: ActivityViewModel
) {
    val jobSearchStatus by viewModel.getJobQueryState.collectAsState()
    val context = LocalContext.current

    AppScaffold(
        bottomBar = { BottomNavigatorBar(navController) }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                when (jobSearchStatus) {

                    is UiState.Loading,
                    is UiState.Idle,
                    is UiState.Success -> {
                        LazyColumn(
                            modifier = Modifier
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
                            item {
                                JobSearchFilter(viewModel)
                            }
                        }

                        FindJobs(
                            modifier = Modifier.align(Alignment.BottomCenter),
                            viewModel = viewModel,
                            activityViewModel = activityViewModel
                        )

                        if (jobSearchStatus is UiState.Success) {
                            val response =
                                (jobSearchStatus as UiState.Success<CustomResponse<String>>).data.data

                            val keywords = viewModel.searchText.value
                                .split(",")
                                .map { it.trim() }
                                .filter { it.isNotEmpty() }

                            if (!response.isNullOrBlank() && response != "null" &&
                                !response.contains("Not+Possible") &&
                                keywords.any { keyword ->
                                    response.contains(
                                        keyword,
                                        ignoreCase = true
                                    )
                                }
                            ) {
                                LaunchedEffect(response) {
                                    openLinkedInJobSearch(context = context, url = response)
                                    viewModel.reset();
                                }
                            } else {
                                CenteredErrorText("No jobs found. Please try again.")
                            }
                        }
                    }

                    is UiState.Failed -> {
                        CenteredErrorText("Something went wrong. Please try again.")
                    }
                }
            }
        }
    }
}

@Composable
private fun CenteredErrorText(message: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        androidx.compose.material3.Text(
            text = message,
            color = MaterialTheme.colorScheme.error,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}