package com.example.applymate.presentation.components.jobSearch

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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
            colors = OutlinedTextFieldDefaults.colors(
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
                colors = OutlinedTextFieldDefaults.colors(
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