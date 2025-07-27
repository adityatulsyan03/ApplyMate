package com.example.applymate.presentation.components.referral

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.applymate.data.model.Referral
import com.example.applymate.presentation.viewModel.ActivityViewModel

@Composable
fun GenerateReferralMessage(
    modifier: Modifier = Modifier,
    referralContent: Referral,
    onGenerateClick: (Referral) -> Unit,
    activityViewModel: ActivityViewModel
) {
    Button(
        onClick = {
            activityViewModel.getTopTwoActivity()
            onGenerateClick(referralContent)
        },
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text("Generate Referral Message")
    }
}