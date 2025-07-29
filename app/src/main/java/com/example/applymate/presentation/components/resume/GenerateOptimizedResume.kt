package com.example.applymate.presentation.components.resume

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.applymate.presentation.viewModel.ResumeViewModel
import com.example.applymate.data.model.ResumeImproveText
import com.example.applymate.presentation.viewModel.ActivityViewModel

@Composable
fun GenerateOptimizedResume(
    modifier: Modifier = Modifier,
    viewModel: ResumeViewModel,
    resumeText: String?,
    jobDescription: String?,
    activityViewModel: ActivityViewModel,
    enable: Boolean
) {

    Button(
        onClick = {
            activityViewModel.getTopTwoActivity()
            viewModel.improveResume(
                resumeImproveText = ResumeImproveText(
                    resumeText = resumeText ?: "No Data",
                    jdText = jobDescription ?: "No Data"
                )
            )
        },
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
            .fillMaxWidth(),
        enabled = enable
    ) {
        Text("Generate Optimized Resume")
    }
}