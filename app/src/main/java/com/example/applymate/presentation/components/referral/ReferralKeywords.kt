package com.example.applymate.presentation.components.referral

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ReferralKeywords(
    jobTitle: String,
    onJobTitleChange: (String) -> Unit,
    company: String,
    onCompanyChange: (String) -> Unit,
    contactPerson: String,
    onContactPersonChange: (String) -> Unit,
    additionalNotes: String,
    onAdditionalNotesChange: (String) -> Unit
) {

    Text(
        text = "Job Title",
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        color = MaterialTheme.colorScheme.onSecondary
    )

    OutlinedTextField(
        value = jobTitle,
        onValueChange = onJobTitleChange,
        modifier = Modifier.fillMaxWidth(),
        label = {
            Text(
                "e.g. Senior Product Designer",
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.primaryContainer,
            unfocusedBorderColor = MaterialTheme.colorScheme.primaryContainer
        )
    )

    Spacer(modifier = Modifier.height(20.dp))

    Text(
        text = "Company",
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        color = MaterialTheme.colorScheme.onSecondary
    )

    OutlinedTextField(
        value = company,
        onValueChange = onCompanyChange,
        modifier = Modifier.fillMaxWidth(),
        label = {
            Text(
                "e.g. Google",
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.primaryContainer,
            unfocusedBorderColor = MaterialTheme.colorScheme.primaryContainer
        )
    )

    Spacer(modifier = Modifier.height(20.dp))

    Text(
        text = "Contact Person",
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        color = MaterialTheme.colorScheme.onSecondary
    )

    OutlinedTextField(
        value = contactPerson,
        onValueChange = onContactPersonChange,
        modifier = Modifier.fillMaxWidth(),
        label = {
            Text(
                "e.g. Sarah from HR",
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.primaryContainer,
            unfocusedBorderColor = MaterialTheme.colorScheme.primaryContainer
        )
    )

    Spacer(modifier = Modifier.height(20.dp))

    Text(
        text = "Additional Notes (Optional)",
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        color = MaterialTheme.colorScheme.onSecondary
    )

    OutlinedTextField(
        value = additionalNotes,
        onValueChange = onAdditionalNotesChange,
        modifier = Modifier.fillMaxWidth(),
        label = {
            Text(
                "Any specific details you'd like to include...",
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.primaryContainer,
            unfocusedBorderColor = MaterialTheme.colorScheme.primaryContainer
        )
    )
}