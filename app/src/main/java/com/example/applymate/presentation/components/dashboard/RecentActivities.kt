package com.example.applymate.presentation.components.dashboard

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.applymate.common.UiState
import com.example.applymate.common.iconInfoMapByIcon
import com.example.applymate.data.localDatas.activities
import com.example.applymate.presentation.viewModel.ActivityViewModel
import com.example.applymate.utils.customShadow
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.rememberNavController
import com.example.applymate.common.HandleUiState
import com.example.applymate.data.model.CustomResponse
import com.example.applymate.data.model.RecentActivity

@Composable
fun RecentActivities(
    navController: NavHostController,
    viewModel: ActivityViewModel,
    homeScreenState: UiState.Idle
) {

    val activityState by viewModel.getTopTwoActivityState.collectAsState()

    LaunchedEffect(activityState) {
        if(activityState is UiState.Idle){
            viewModel.getTopTwoActivity()
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
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.secondary)
            .padding(16.dp)
    ) {
        activityState.HandleUiState(
            idleBlock = {
                viewModel.getTopTwoActivity()
            },
            background = MaterialTheme.colorScheme.secondary,
            successBlock = {
                Text(
                    text = "Recent Activity",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onPrimary
                )
                val activity = (activityState as UiState.Success<CustomResponse<List<RecentActivity>>>).data.data ?: emptyList()
                if (activity.isEmpty())
                    Text("No Activity Recently")
                else
                    activity.forEach { activity ->
                        Log.d("Debug Logs",activity.toString())
                        ActivityCard(
                            activity = activity, modifier = Modifier.padding(vertical = 8.dp),
                            colorMap = iconInfoMapByIcon,
                            navController = navController
                        )
                    }
//                activities.forEach { activity ->
//                    ActivityCard(
//                        activity = activity, modifier = Modifier.padding(vertical = 8.dp),
//                        colorMap = iconInfoMapByIcon,
//                        navController = navController
//                    )
//                }
            }
        )
    }
}

@Composable
fun HardCodedData() {
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
            navController = rememberNavController()
        )
    }
}