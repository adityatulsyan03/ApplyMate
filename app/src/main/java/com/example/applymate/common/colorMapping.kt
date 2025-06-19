package com.example.applymate.common

import androidx.compose.ui.graphics.Color
import com.example.applymate.R

data class IconInfo(
    val iconResId: Int,
    val color: Color,
    val description: String
)

val iconInfoList = listOf(
    IconInfo(R.drawable.resume_action, Color(0xFF9333EA), "Resume Action"),
    IconInfo(R.drawable.referral_action, Color(0xFFEA580C), "Referral Action"),
    IconInfo(R.drawable.jobs_action, Color(0xFF2563EB), "Jobs Action"),
    IconInfo(R.drawable.chat_action, Color(0xFF16A34A), "Chat Action"),
    IconInfo(R.drawable.improve_suggestion, Color(0xFFD97706), "Improve Suggestion"),
    IconInfo(R.drawable.good_suggestion, Color(0xFF16A34A), "Good Suggestion")
)

val iconInfoMapByIcon = iconInfoList.associateBy { it.iconResId }

val iconInfoByDesc = iconInfoList.associateBy { it.description }