package com.example.applymate.presentation.components.resume

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ResumeReview() {
    Text(
        text = "Resume Preview",
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        color = MaterialTheme.colorScheme.onPrimary
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(150.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text("Hello My Name is Aditya, This is my resume I would like to work in your company as a Junior SDE.Hello My Name is Aditya, This is my resume I would like to work in your company as a Junior SDE.Hello My Name is Aditya, This is my resume I would like to work in your company as a Junior SDE.Hello My Name is Aditya, This is my resume I would like to work in your company as a Junior SDE.Hello My Name is Aditya, This is my resume I would like to work in your company as a Junior SDE.")
    }
}