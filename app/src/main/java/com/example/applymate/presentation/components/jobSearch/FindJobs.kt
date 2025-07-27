package com.example.applymate.presentation.components.jobSearch

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.applymate.data.model.JobSearch
import com.example.applymate.presentation.viewModel.ActivityViewModel
import com.example.applymate.presentation.viewModel.JobSearchViewModel

@Composable
fun FindJobs(
    modifier: Modifier = Modifier,
    viewModel: JobSearchViewModel,
    activityViewModel: ActivityViewModel
) {
    Button(
        onClick = {
            activityViewModel.getTopTwoActivity()
            viewModel.getJobQuery(
                JobSearch(
                    searchText = viewModel.searchText.value,
                    timeValue = viewModel.selectedTimeValue.value,
                    timeUnit = viewModel.selectedTimeUnit.value,
                    workType = viewModel.selectedWorkTypes.toList(),
                    experienceLevel = viewModel.selectedExperienceLevels.toList(),
                    easyApply = viewModel.isEasyApplyEnabled.value,
                    verified = viewModel.isVerificationEnabled.value,
                    yourNetwork = viewModel.isInYourNetworkEnabled.value,
                    noOfApplications = viewModel.isNoOfApplicantsEnabled.value
                )
            )
        },
        enabled = viewModel.searchText.value.length >= 2 ,
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text("Find Jobs")
    }
}