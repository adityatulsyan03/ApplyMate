package com.example.applymate.presentation.components.resume

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.applymate.R
import com.example.applymate.presentation.components.core.DocumentUploader
import com.example.applymate.presentation.components.core.Header
import com.example.applymate.ui.theme.ApplyMateTheme

//TODO: Give option to select if text or pdf or something
@Composable
fun UploadResumeDocument() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        DocumentUploader(
            image = R.drawable.resume_selected,
            imageDesc = "Resume"
        ) { fileUri ->

            Log.d("Document Name", "Resume File Url: $fileUri")

        }
        DocumentUploader(
            image = R.drawable.job_upload,
            imageDesc = "Job Description"
        ) { fileUri ->

            Log.d("Document Name", "Job Description File Url: $fileUri")

        }
    }
}