package com.example.applymate.presentation.components.dashboard

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.applymate.R
import com.example.applymate.common.IconInfo
import com.example.applymate.data.model.RecentActivity
import com.example.applymate.presentation.navigation.Screens
import com.example.applymate.utils.safeNavigateOnce
import java.util.Date
import java.util.concurrent.TimeUnit

@Composable
fun ActivityCard(
    activity: RecentActivity,
    modifier: Modifier = Modifier,
    colorMap: Map<Int, IconInfo>,
    navController: NavHostController
) {
    val iconRes = activity.icon
    val iconDesc = colorMap[iconRes]?.description
    val baseColor = colorMap[iconRes]?.color ?: Color.Gray
    val backgroundColor = baseColor.copy(alpha = 0.2f)

    val nav = when(activity.icon){
        R.drawable.referral_action -> Screens.ReferralScreen.route
        R.drawable.resume_action -> Screens.ResumeScreen.route
        R.drawable.chat_action -> Screens.ChatScreen.route
        R.drawable.jobs_action -> Screens.JobScreen.route
        else -> Screens.HomeScreen.route
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp, vertical = 2.dp)
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .clickable {
                    navController.safeNavigateOnce(nav)
                }
                .background(backgroundColor),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(iconRes),
                contentDescription = iconDesc,
                modifier = Modifier.size(25.dp),
                tint = Color.Unspecified
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = activity.action,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = activity.topic,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Spacer(modifier = Modifier.width(4.dp))
                val circleColor = MaterialTheme.colorScheme.onPrimaryContainer
                Canvas(modifier = Modifier.size(4.dp)) {
                    drawCircle(
                        color = circleColor,
                        radius = 6f
                    )
                }
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = getTimeAgo(activity.date),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
    }
}

fun getTimeAgo(date: Date): String {
    val now = Date()
    val diffMillis = now.time - date.time

    if (diffMillis < 0) return "Just now"

    val minutes = TimeUnit.MILLISECONDS.toMinutes(diffMillis)
    val hours = TimeUnit.MILLISECONDS.toHours(diffMillis)
    val days = TimeUnit.MILLISECONDS.toDays(diffMillis)

    return when {
        minutes < 1 -> "Just now"
        minutes < 60 -> "$minutes minute${if (minutes == 1L) "" else "s"} ago"
        hours < 24 -> "$hours hour${if (hours == 1L) "" else "s"} ago"
        days < 30 -> "$days day${if (days == 1L) "" else "s"} ago"
        days < 365 -> {
            val months = days / 30
            "$months month${if (months == 1L) "" else "s"} ago"
        }
        else -> {
            val years = days / 365
            "$years year${if (years == 1L) "" else "s"} ago"
        }
    }
}