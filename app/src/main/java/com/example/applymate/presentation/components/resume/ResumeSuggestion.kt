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
            Text(
                text = "Loading suggestions...",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }

        is UiState.Failed -> {
            val message = (resumeState as UiState.Failed).message
            Text(
                text = "Error: $message",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.error
            )
        }

        is UiState.Idle -> {
            Text(
                text = "Upload documents to get the suggestions",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}