package com.example.applymate.presentation.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CardTravel
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.applymate.presentation.components.naviagtions.AppScaffold
import com.example.applymate.presentation.navigation.BottomNavigatorBar
import com.example.applymate.ui.theme.ApplyMateTheme
import com.example.applymate.utils.safePopBackStack
import com.example.applymate.R

@Composable
fun HomeScreen(navController: NavHostController) {

    BackHandler {
        navController.safePopBackStack()
    }

    ApplyMateTheme {
        AppScaffold(
            bottomBar = {
                BottomNavigatorBar(navController)
            }
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(horizontal = 16.dp)
            ) {
                LazyColumn(
                    modifier = Modifier.background(MaterialTheme.colorScheme.background),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    item {
                        HomeHeading()
                    }
                    item {
                        //TODO: Can remove this and give an option to enter your own AI API Key
                        HomeSearchFilter()
                    }
                    item {
                        RecentActivities()
                    }
                    item {
                        QuickAction()
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeSearchFilter() {
    var searchText by remember { mutableStateOf("") }
    OutlinedTextField(
        value = searchText,
        onValueChange = {
            searchText = it
        },
        modifier = Modifier.fillMaxWidth(),
        leadingIcon = {
            IconButton(
                onClick = {
                    //TODO: Search Implement
                },
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    modifier = Modifier.size(30.dp),
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        },
        label = {
            Text(
                "Search for a job role...",
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colorScheme.primaryContainer,
            unfocusedBorderColor = MaterialTheme.colorScheme.primaryContainer
        )
    )
}

@Composable
fun HomeHeading() {
    Text(
        text = "Good Morning, User",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.onPrimary
    )
    Text(
        text = "Let's find your dream job today",
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        color = MaterialTheme.colorScheme.onSecondary
    )
}

@Composable
fun QuickAction() {
    val actions = listOf(
        listOf("Find Jobs", "Search roles on LinkedIn", Color(0xFFEFF6FF)),
        listOf("Optimize Resume", "Make it ATS-friendly", Color(0xFFFAF5FF)),
        listOf("Chat with Docs", "Upload & ask questions", Color(0xFFF0FDF4)),
        listOf("Get Referrals", "Generate messages", Color(0xFFFFF7ED))
    )

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Quick Action",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
        )

        actions.chunked(2).forEach { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                rowItems.forEach { item ->
                    ActionCard(item, Modifier.weight(1f))
                }
                if (rowItems.size == 1) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
fun ActionCard(activity: List<Any>, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(150.dp)
            .background(activity[2] as Color, shape = RoundedCornerShape(12.dp))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.CardTravel,
                contentDescription = null
            )
            Text(
                text = activity[0].toString(),
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Text(
                text = activity[1].toString(),
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colorScheme.onSecondary
            )
        }
    }
}

@Composable
fun RecentActivities() {
    val activities = listOf(
        listOf("Resume Optimized", "FrontEnd Developer", "2 days ago", R.drawable.resume_action),
        listOf("Referral Message Sent", "Google Product Manager", "3 days ago", R.drawable.referral_action)
    )

    val iconColorMap = mapOf(
        R.drawable.resume_action to Pair(Color(0xFF9333EA),"Resume Action"),
        R.drawable.referral_action to Pair(Color(0xFFEA580C),"Referral Action"),
        R.drawable.jobs_action to Pair(Color(0xFF2563EB),"Jobs Action"),
        R.drawable.chat_action to Pair(Color(0xFF16A34A),"Chat Action"),
        R.drawable.error_suggestion to Pair(Color(0xFFD97706),"Error Suggestion"),
        R.drawable.good_suggestion to Pair(Color(0xFF16A34A),"Good Suggestion")
    )


    Column(
        modifier = Modifier
            .padding(2.dp)
            .shadow(6.dp, RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .border(
                width = 2.dp,
                color = Color(0xFFF3F4F6),
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
            ActivityCompose(activity = activity, modifier = Modifier.padding(vertical = 8.dp),colorMap = iconColorMap)
        }
    }
}

@Composable
fun ActivityCompose(activity: List<Any>, modifier: Modifier = Modifier, colorMap: Map<Int, Pair<Color,String>>) {
    val iconRes = activity[3] as Int
    val iconDesc = colorMap[iconRes]?.second
    val baseColor = colorMap[iconRes]?.first ?: Color.Gray
    val backgroundColor = baseColor.copy(alpha = 0.2f)
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
                text = activity[0].toString(),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = activity[1].toString(),
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
                    text = activity[2].toString(),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
    }
}