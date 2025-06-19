package com.example.applymate.presentation.components.resume

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.applymate.R
import com.example.applymate.common.IconInfo
import com.example.applymate.data.model.Suggestions

@Composable
fun SuggestionList(suggestions: Suggestions, iconColorMap: Map<Int, IconInfo>) {
    val iconRes = if(suggestions.isGood) R.drawable.good_suggestion else R.drawable.improve_suggestion
    val baseColor = iconColorMap[iconRes]?.color ?: Color.Gray
    val iconDesc = iconColorMap[iconRes]?.description
    val backgroundColor = baseColor.copy(alpha = 0.05f)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .background(backgroundColor)
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        Icon(
            painter = painterResource(iconRes),
            contentDescription = iconDesc,
            modifier = Modifier.size(20.dp),
            tint = Color.Unspecified
        )
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = suggestions.inShort,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Text(
                text = suggestions.toDo,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}