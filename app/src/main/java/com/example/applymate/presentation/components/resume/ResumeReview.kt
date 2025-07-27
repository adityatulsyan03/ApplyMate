package com.example.applymate.presentation.components.resume

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.applymate.utils.customShadow

@Composable
fun ResumeReview(resumeText: String?) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
            .customShadow(
                color = Color.Black.copy(alpha = 0.2f),
                borderRadius = 12.dp,
                blurRadius = 4.dp,
                offsetY = 2.dp,
                offsetX = 0.dp,
                spread = 0.dp
            )
            .padding(1.dp)
            .customShadow(
                color = Color.Black.copy(alpha = 0.4f),
                borderRadius = 12.dp,
                blurRadius = 4.dp,
                offsetY = 4.dp,
                offsetX = 0.dp,
                spread = 0.dp
            )
            .background(MaterialTheme.colorScheme.secondary, shape = RoundedCornerShape(12.dp))
    ) {
        val scrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
        ) {
            Spacer(Modifier.height(12.dp))
            Text(
                text = "Resume Preview",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.fillMaxWidth()
            )
            Row(
                modifier = Modifier.fillMaxSize().height(160.dp)
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .verticalScroll(scrollState)
                        .padding(end = 8.dp)
                ) {
                    Text(
                        text = resumeText ?: "Upload the File to see the content",
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }

                val scrollRatio =
                    scrollState.value.toFloat() / scrollState.maxValue.coerceAtLeast(1)
                val thumbHeightRatio =
                    150f / (scrollState.maxValue + 150).toFloat()

                if (scrollState.maxValue > 0) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight(0.95f)
                            .width(4.dp)
                            .background(Color.Gray.copy(alpha = 0.2f), RoundedCornerShape(2.dp))
                    ) {
                        Box(
                            modifier = Modifier
                                .width(4.dp)
                                .height((160 * thumbHeightRatio).dp)
                                .padding(horizontal = 0.5.dp)
                                .offset(y = (scrollRatio * (150 - (150 * thumbHeightRatio))).dp)
                                .background(Color.Gray, RoundedCornerShape(2.dp))
                        )
                    }
                }
            }
        }
    }
}