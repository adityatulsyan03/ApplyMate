package com.example.applymate.presentation.components.jobSearch

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.applymate.data.enums.ExperienceLevel
import com.example.applymate.data.enums.TimeUnit
import com.example.applymate.data.enums.WorkType
import com.example.applymate.data.model.JobSearch
import com.example.applymate.presentation.viewModel.JobSearchViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun JobSearchFilter(viewModel: JobSearchViewModel) {

    val searchText = viewModel.searchText
    val selectedTimeValue = viewModel.selectedTimeValue
    val selectedTimeUnit = viewModel.selectedTimeUnit
    val selectedWorkTypes = viewModel.selectedWorkTypes
    val selectedExperienceLevels = viewModel.selectedExperienceLevels
    val isEasyApplyEnabled = viewModel.isEasyApplyEnabled
    val isVerificationEnabled = viewModel.isVerificationEnabled
    val isInYourNetworkEnabled = viewModel.isInYourNetworkEnabled
    val isNoOfApplicantsEnabled = viewModel.isNoOfApplicantsEnabled
    val timeUnitOptions = enumValues<TimeUnit>().toList()
    val workTypes = enumValues<WorkType>().toList()
    val experienceLevels = enumValues<ExperienceLevel>().toList()

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        SearchBox(
            value = searchText.value,
            onValueChange = { searchText.value = it },
            leadingIcon = Icons.Default.Search,
            leadingIconDesc = "Search",
            placeholder = "Enter job role (e.g. UX Designer)"
        )

        Text(
            text = "Date Posted",
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = MaterialTheme.colorScheme.onSecondary
        )

        TimeAgoDropdown(
            onTimeValueSelected = { selectedTimeValue.value = it },
            timeUnitOptions = timeUnitOptions,
            onTimeUnitSelected = { selectedTimeUnit.value = it }
        )

        Text(
            text = "Work Type",
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = MaterialTheme.colorScheme.onSecondary
        )

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            workTypes.forEach { workType ->
                val isSelected = selectedWorkTypes.contains(workType)

                FilterChip(
                    selected = isSelected,
                    onClick = {
                        if (isSelected) selectedWorkTypes.remove(workType)
                        else selectedWorkTypes.add(workType)
                    },
                    label = {
                        Box(
                            modifier = Modifier.padding(horizontal = 6.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = workType.name,
                                fontSize = 18.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                    },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = MaterialTheme.colorScheme.primary,
                        selectedLabelColor = MaterialTheme.colorScheme.primaryContainer,
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        labelColor = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                )
            }
        }

        Text(
            text = "Experience Level",
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = MaterialTheme.colorScheme.onSecondary
        )

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            experienceLevels.forEach { experience ->
                val isSelected = selectedExperienceLevels.contains(experience)

                FilterChip(
                    selected = isSelected,
                    onClick = {
                        if (isSelected) selectedExperienceLevels.remove(experience)
                        else selectedExperienceLevels.add(experience)
                    },
                    label = {
                        Box(
                            modifier = Modifier.padding(horizontal = 6.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = experience.name,
                                fontSize = 18.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                    },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = MaterialTheme.colorScheme.primary,
                        selectedLabelColor = MaterialTheme.colorScheme.primaryContainer,
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        labelColor = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                )
            }
        }

        CheckBox(
            label = "Easy Apply",
            checked = isEasyApplyEnabled.value,
            onCheckedChange = { isEasyApplyEnabled.value = it }
        )
        CheckBox(
            label = "Is Verified",
            checked = isVerificationEnabled.value,
            onCheckedChange = { isVerificationEnabled.value = it }
        )
        CheckBox(
            label = "In Your Network",
            checked = isInYourNetworkEnabled.value,
            onCheckedChange = { isInYourNetworkEnabled.value = it }
        )
        CheckBox(
            label = "No. of Applicants",
            checked = isNoOfApplicantsEnabled.value,
            onCheckedChange = { isNoOfApplicantsEnabled.value = it }
        )
    }
}