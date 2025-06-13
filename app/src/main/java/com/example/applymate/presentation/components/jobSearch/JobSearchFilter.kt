package com.example.applymate.presentation.components.jobSearch

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun JobSearchFilter() {

    var searchText by remember { mutableStateOf("") }
    var selectedTimeValue by remember { mutableStateOf("1") }
    val timeUnitOptions = listOf("Hours","Days","Weeks")
    var selectedTimeUnit by remember { mutableStateOf("Hours") }
    val workTypes = listOf("On-Site","Remote","Hybrid")
    val selectedWorkTypes = remember { mutableStateListOf<String>() }
    val experienceLevels = listOf("Internship","Entry Level","Associate","Mid-Senior Level","Director","Executive")
    val selectedExperienceLevels = remember { mutableStateListOf<String>() }
    var isEasyApplyEnabled by remember { mutableStateOf(false) }
    var isVerificationEnabled by remember { mutableStateOf(false) }
    var isInYourNetworkEnabled by remember { mutableStateOf(false) }
    var isNoOfApplicantsEnabled by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        SearchBox(
            value = searchText,
            onValueChange = {searchText = it},
            leadingIcon = Icons.Default.Search,
            leadingIconDesc = "Search",
            onClick = {
                    //TODO: Search for Job
            },
            placeholder = "Enter job role (e.g. UX Designer)"
        )
        Text(
            text = "Date Posted",
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = MaterialTheme.colorScheme.onSecondary
        )

        TimeAgoDropdown(
            onTimeValueSelected = { selectedTimeValue = it },
            timeUnitOptions = timeUnitOptions,
            onTimeUnitSelected = { selectedTimeUnit = it }
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
                        if (isSelected) {
                            selectedWorkTypes.remove(workType)
                        } else {
                            selectedWorkTypes.add(workType)
                        }
                    },
                    label = {
                        Box(
                            modifier = Modifier
                                .padding(horizontal = 6.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = workType,
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
                        if (isSelected) {
                            selectedExperienceLevels.remove(experience)
                        } else {
                            selectedExperienceLevels.add(experience)
                        }
                    },
                    label = {
                        Box(
                            modifier = Modifier
                                .padding(horizontal = 6.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = experience,
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
            checked = isEasyApplyEnabled,
            onCheckedChange = { isEasyApplyEnabled = it })
        CheckBox(
            label = "Is Verified",
            checked = isVerificationEnabled,
            onCheckedChange = { isVerificationEnabled = it })
        CheckBox(
            label = "In Your Network",
            checked = isInYourNetworkEnabled,
            onCheckedChange = { isInYourNetworkEnabled = it })
        CheckBox(
            label = "No. of Applicants",
            checked = isNoOfApplicantsEnabled,
            onCheckedChange = { isNoOfApplicantsEnabled = it })
    }
}