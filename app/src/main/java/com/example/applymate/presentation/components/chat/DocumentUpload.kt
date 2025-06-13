package com.example.applymate.presentation.components.chat

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.applymate.R
import com.example.applymate.constants.iconInfoMapByIcon
import com.example.applymate.utils.dashedBorder

@Composable
fun DocumentUpload() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Upload Job",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onPrimary
        )
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
                text = "PDF, DOCX, or TXT",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Button(
                onClick = {},
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text("Browse Files")
            }
        }
    }
}