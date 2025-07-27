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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.applymate.common.UiState
import com.example.applymate.presentation.components.core.Header
import com.example.applymate.presentation.components.naviagtions.AppScaffold
import com.example.applymate.presentation.components.resume.GenerateOptimizedResume
import com.example.applymate.presentation.components.resume.ResumeReview
import com.example.applymate.presentation.components.resume.ResumeSuggestion
import com.example.applymate.presentation.components.resume.UploadResumeDocument
import com.example.applymate.presentation.navigation.BottomNavigatorBar
import com.example.applymate.presentation.viewModel.ActivityViewModel
import com.example.applymate.presentation.viewModel.DocumentViewModel
import com.example.applymate.presentation.viewModel.ResumeViewModel

@Composable
fun ResumeScreen(
    navController: NavController,
    documentViewModel: DocumentViewModel,
    viewModel: ResumeViewModel,
    activityViewModel: ActivityViewModel
) {

    val resumeState by documentViewModel.resumeState.collectAsState()
    val jdState by documentViewModel.jdState.collectAsState()

    val resumeText = when (resumeState) {
        is UiState.Success -> (resumeState as UiState.Success).data.data?.documentText
        else -> null
    }

    val jobDescription = when (jdState) {
        is UiState.Success -> (jdState as UiState.Success).data.data?.documentText
        else -> null
    }


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
                            first = "Resume Optimization",
                            second = "Get AI suggestions to improve your resume"
                        )
                    }
                    item {
                        UploadResumeDocument(
                            viewModel = documentViewModel
                        )
                    }
                    item { ResumeReview(resumeText = resumeText) }
                    item { ResumeSuggestion(viewModel) }
                }
                GenerateOptimizedResume(
                    modifier = Modifier.align(Alignment.BottomCenter),
                    viewModel = viewModel,
                    resumeText = resumeText,
                    jobDescription = jobDescription,
                    activityViewModel = activityViewModel
                )
            }
        }

    }
}