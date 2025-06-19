package com.example.applymate.presentation.components.core

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.applymate.R
import com.example.applymate.common.iconInfoMapByIcon
import com.example.applymate.utils.customShadow
import com.example.applymate.utils.dashedBorder

@Composable
fun DocumentUploader(
    image: Int,
    imageDesc: String,
    onFileSelected: (Uri) -> Unit // Callback when a file is selected
) {
    var selectedFileUri by remember { mutableStateOf<Uri?>(null) }

    // File picker launcher
    val filePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            selectedFileUri = it
            onFileSelected(it)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
            .customShadow(
                color = Color.Black.copy(alpha = 0.2f),
                borderRadius = 12.dp,
                blurRadius = 4.dp,
                offsetY = 6.dp,
                offsetX = 0.dp,
                spread = 0.dp
            )
            .background(MaterialTheme.colorScheme.secondary, shape = RoundedCornerShape(12.dp))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(image),
                contentDescription = imageDesc,
                modifier = Modifier.size(20.dp),
                tint = Color.Unspecified
            )
            Text(
                text = "Upload $imageDesc",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .dashedBorder(
                    strokeWidth = 1.dp,
                    color = MaterialTheme.colorScheme.tertiary,
                    cornerRadius = 16.dp,
                    dashLength = 10.dp,
                    gapLength = 5.dp
                )
                .padding(24.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.upload_icon),
                contentDescription = "Upload",
                modifier = Modifier.size(20.dp),
                tint = iconInfoMapByIcon[R.drawable.upload_icon]?.color
                    ?: MaterialTheme.colorScheme.onPrimary
            )
            Text(
                text = "Drag and drop or click to upload",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Text(
                text = "Text or PDF format",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Button(
                onClick = {
                    // Launch file picker
                    filePickerLauncher.launch("*/*") // use "application/pdf" for only PDF
                },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text("Browse Files")
            }

            // Show selected file info
            selectedFileUri?.let {
                Text(
                    text = "Selected: ${it.lastPathSegment}",
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}