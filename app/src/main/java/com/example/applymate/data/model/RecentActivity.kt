package com.example.applymate.data.model

import com.example.applymate.R
import com.example.applymate.common.iconInfoByDesc
import java.util.Date

data class RecentActivity(
    val activityId: Long,
    val activityName: String,
    val activityDescription: String,
    val activityDate: Date,
    val activityType: String
)