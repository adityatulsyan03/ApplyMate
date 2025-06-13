package com.example.applymate.presentation.components.jobSearch

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.primaryContainer,
            unfocusedBorderColor = MaterialTheme.colorScheme.primaryContainer
        )
    )
}