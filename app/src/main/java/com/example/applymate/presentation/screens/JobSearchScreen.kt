package com.example.applymate.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.applymate.R
import com.example.applymate.presentation.components.naviagtions.AppScaffold
import com.example.applymate.presentation.components.naviagtions.TopBar
import com.example.applymate.presentation.navigation.BottomNavigatorBar
import com.example.applymate.ui.theme.ApplyMateTheme

@Composable
fun JobScreen(navController: NavHostController) {

    AppScaffold(
        topBar = {
            TopBar(
                title = "Job Search"
            )
        },
        bottomBar = {
            BottomNavigatorBar(navController)
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                LazyColumn(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    contentPadding = PaddingValues(bottom = 80.dp)
                ) {
                    item { JobHeading() }
                    item { JobSearchFilter() }
                }
                Button(
                    onClick = {},
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .align(Alignment.BottomCenter)
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    Text("Find Jobs")
                }
            }
        }
    }

}

@Composable
fun JobScreenContent() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                contentPadding = PaddingValues(bottom = 80.dp)
            ) {
                item { JobHeading() }
                item { JobSearchFilter() }
            }
            Button(
                onClick = {},
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text("Find Jobs")
            }
        }
    }
}

@Composable
fun JobSearchFilter() {
    var searchText by remember { mutableStateOf("") }
    var advanceOption by remember { mutableStateOf(false) }
    SearchBox(
        value = searchText,
        onValueChange = {searchText = it},
        leadingIcon = Icons.Default.Search,
        leadingIconDesc = "Search",
        onClick = {},
        placeholder = "Enter job role (e.g. UX Designer)"
    )
//    Spacer(Modifier.height(8.dp))
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .border(
//                width = 1.dp,
//                color = MaterialTheme.colorScheme.primaryContainer,
//                shape = RoundedCornerShape(8.dp)
//            )
//            .padding(horizontal = 12.dp, vertical = 8.dp),
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.SpaceBetween
//    ) {
//        Icon(
//            painter = painterResource(id = R.drawable.filter),
//            contentDescription = "Filter",
//            modifier = Modifier.size(30.dp),
//            tint = MaterialTheme.colorScheme.onPrimaryContainer
//        )
//
//        Text(
//            text = "Advance Filter",
//            fontSize = 18.sp,
//            color = MaterialTheme.colorScheme.onPrimaryContainer,
//            modifier = Modifier
//                .weight(1f)
//                .padding(start = 12.dp)
//        )
//
//        IconButton(onClick = { advanceOption = !advanceOption }) {
//            Icon(
//                imageVector = Icons.Default.KeyboardArrowDown,
//                contentDescription = "Toggle Filter Options",
//                modifier = Modifier.size(30.dp),
//                tint = MaterialTheme.colorScheme.onPrimaryContainer
//            )
//        }
//    }
    AdvanceSelected()
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun AdvanceSelected() {

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
        Spacer(Modifier.height(8.dp))
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
                        selectedContainerColor = MaterialTheme.colorScheme.onPrimaryContainer,
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
                        selectedContainerColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        selectedLabelColor = MaterialTheme.colorScheme.primaryContainer,
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        labelColor = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Easy Apply",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colorScheme.onSecondary
            )
            Checkbox(
                checked = isEasyApplyEnabled,
                onCheckedChange = { isEasyApplyEnabled = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = MaterialTheme.colorScheme.primaryContainer,
                    checkmarkColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    uncheckedColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Has verifications",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colorScheme.onSecondary
            )
            Checkbox(
                checked = isVerificationEnabled,
                onCheckedChange = { isVerificationEnabled = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = MaterialTheme.colorScheme.primaryContainer,
                    checkmarkColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    uncheckedColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "In Your Network",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colorScheme.onSecondary
            )
            Checkbox(
                checked = isInYourNetworkEnabled,
                onCheckedChange = { isInYourNetworkEnabled = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = MaterialTheme.colorScheme.primaryContainer,
                    checkmarkColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    uncheckedColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = "No. of Applicants",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colorScheme.onSecondary
            )
            Checkbox(
                checked = isNoOfApplicantsEnabled,
                onCheckedChange = { isNoOfApplicantsEnabled = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = MaterialTheme.colorScheme.primaryContainer,
                    checkmarkColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    uncheckedColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeAgoDropdown(
    onTimeValueSelected: (String) -> Unit,
    timeUnitOptions: List<String>,
    onTimeUnitSelected: (String) -> Unit
) {
    var expandValue by remember { mutableStateOf(false) }
    var timeUnit by remember { mutableStateOf("Hours") }
    var timeValue by remember { mutableStateOf("1") }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        OutlinedTextField(
            value = timeValue,
            onValueChange = {
                timeValue = it
                onTimeValueSelected(it)
            },
            modifier = Modifier.weight(0.4f),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                disabledBorderColor = MaterialTheme.colorScheme.primaryContainer,
                disabledTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                disabledTrailingIconColor = MaterialTheme.colorScheme.onPrimaryContainer
            )
        )
        ExposedDropdownMenuBox(
            expanded = expandValue,
            onExpandedChange = { expandValue = !expandValue },
            modifier = Modifier.weight(1f)
        ) {
            OutlinedTextField(
                value = timeUnit,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandValue)
                },
                modifier = Modifier.menuAnchor(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    disabledBorderColor = MaterialTheme.colorScheme.primaryContainer,
                    disabledTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    disabledTrailingIconColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )

            ExposedDropdownMenu(
                expanded = expandValue,
                onDismissRequest = { expandValue = false },
                modifier = Modifier.background(MaterialTheme.colorScheme.primaryContainer)
            ) {
                timeUnitOptions.forEach { selectionOption ->
                    DropdownMenuItem(
                        text = { Text(selectionOption) },
                        onClick = {
                            timeUnit = selectionOption
                            expandValue = false
                            onTimeUnitSelected(selectionOption)
                        },
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.primaryContainer)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBox(
    value: String,
    onValueChange: (String) -> Unit,
    leadingIcon: ImageVector,
    leadingIconDesc: String,
    onClick: () -> Unit,
    placeholder: String
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        leadingIcon = {
            IconButton(
                onClick = {
                    onClick()
                },
            ) {
                Icon(
                    imageVector = leadingIcon,
                    contentDescription = leadingIconDesc,
                    modifier = Modifier.size(30.dp),
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        },
        label = {
            Text(
                placeholder,
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colorScheme.primaryContainer,
            unfocusedBorderColor = MaterialTheme.colorScheme.primaryContainer
        )
    )
}

@Composable
fun JobHeading() {
    Text(
        text = "Smart Job Finder",
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.onPrimary
    )
    Text(
        text = "Find relevant jobs on LinkedIn",
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        color = MaterialTheme.colorScheme.onSecondary
    )
}

@Preview
@Composable
private fun JobPreview() {
    ApplyMateTheme {
        JobScreenContent()
    }
}