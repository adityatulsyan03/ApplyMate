package com.example.applymate.presentation.components.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.applymate.R
import com.example.applymate.constants.iconInfoMapByIcon
import com.example.applymate.data.model.Action
import com.example.applymate.presentation.navigation.Screens
import com.example.applymate.utils.safeNavigateOnce
import com.example.applymate.utils.safePopBackStack

@Composable
fun ActionCard(activity: Action, modifier: Modifier = Modifier, navController: NavHostController) {
    val iconColor = iconInfoMapByIcon[activity.icon]?.color ?: Color.Gray
    val backgroundColor = iconColor.copy(alpha = 0.15f)
    val nav = when(activity.icon){
        R.drawable.referral_action -> Screens.ReferralScreen.route
        R.drawable.resume_action -> Screens.ResumeScreen.route
        R.drawable.chat_action -> Screens.ChatScreen.route
        R.drawable.jobs_action -> Screens.JobScreen.route
        else -> Screens.HomeScreen.route
    }

    Box(
        modifier = modifier
            .height(150.dp)
            .background(backgroundColor, shape = RoundedCornerShape(12.dp))
            .padding(16.dp)
            .clickable {
                navController.safeNavigateOnce(nav)
            },
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                painter = painterResource(activity.icon),
                contentDescription = activity.type,
                tint = iconInfoMapByIcon[activity.icon]?.color ?: MaterialTheme.colorScheme.onPrimary
            )
            Text(
                text = activity.type,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Text(
                text = activity.does,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colorScheme.onSecondary
            )
        }
    }
}