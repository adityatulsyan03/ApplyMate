package com.example.applymate.presentation.components.resume

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.applymate.common.UiState
import com.example.applymate.common.iconInfoMapByIcon
import com.example.applymate.data.model.CustomResponse
import com.example.applymate.data.model.Suggestions
import com.example.applymate.presentation.viewModel.ResumeViewModel
import com.example.applymate.presentation.components.core.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Assignment

@Composable
fun ResumeSuggestion(viewModel: ResumeViewModel) {

    val resumeState by viewModel.improveResumeState.collectAsState()

    Text(
        text = "AI Suggestions",
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        color = MaterialTheme.colorScheme.onPrimary
    )
    Text(
        text = "Upload a job description to get personalized suggestions",
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        color = MaterialTheme.colorScheme.onPrimary
    )
    when(resumeState){
        is UiState.Success -> {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                val suggestions = (resumeState as UiState.Success<CustomResponse<List<Suggestions>>>).data.data ?: emptyList()
                suggestions.forEach { suggestion ->
                    SuggestionList(suggestion, iconColorMap = iconInfoMapByIcon)
                }
            }
        }
        is UiState.Loading -> {
            LoadingState("Analyzing resume and generating suggestions...")
        }

        is UiState.Failed -> {
            val message = (resumeState as UiState.Failed).message
            ErrorState(
                message = message,
                onRetry = null
            )
        }

        is UiState.Idle -> {
            IdleState(
                icon = Icons.Default.Assignment,
                title = "AI Resume Analysis",
                subtitle = "Upload your resume and job description to get personalized improvement suggestions"
            )
        }
    }
}