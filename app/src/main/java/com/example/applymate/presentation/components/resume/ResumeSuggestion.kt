package com.example.applymate.presentation.components.resume

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.applymate.common.iconInfoMapByIcon
import com.example.applymate.data.localDatas.suggestions

@Composable
fun ResumeSuggestion() {
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
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        suggestions.forEach { suggestion ->
            SuggestionList(suggestion, iconColorMap = iconInfoMapByIcon)
        }
    }
}