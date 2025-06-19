package com.example.applymate.data.model

import com.example.applymate.R
import com.example.applymate.common.iconInfoByDesc
import java.util.Date

data class RecentActivity(
    val action: String,
    val topic: String,
    val date: Date,
    val icon: Int = iconInfoByDesc[action]?.iconResId ?: R.drawable.ic_launcher_foreground
)