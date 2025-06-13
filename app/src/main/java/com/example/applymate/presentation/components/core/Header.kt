package com.example.applymate.presentation.components.core

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Header(first: String,second: String) {
    Text(
        text = first,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.onPrimary
    )
    Spacer(modifier = Modifier.height(4.dp))
    Text(
        text = second,
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        color = MaterialTheme.colorScheme.onSecondary
    )
}