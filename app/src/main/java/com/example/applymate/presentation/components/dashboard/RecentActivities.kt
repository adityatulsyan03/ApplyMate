package com.example.applymate.presentation.components.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.applymate.common.iconInfoMapByIcon
import com.example.applymate.data.localDatas.activities
import com.example.applymate.utils.customShadow

@Composable
fun RecentActivities(navController: NavHostController) {

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
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.secondary)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(16.dp)
    ) {
        Text(
            text = "Recent Activity",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onPrimary
        )
        activities.forEach { activity ->
            ActivityCard(
                activity = activity, modifier = Modifier.padding(vertical = 8.dp),
                colorMap = iconInfoMapByIcon,
                navController = navController
            )
        }
    }
}

