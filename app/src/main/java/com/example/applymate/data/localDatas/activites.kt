package com.example.applymate.data.localDatas

import android.annotation.SuppressLint
import com.example.applymate.data.model.RecentActivity
import java.text.SimpleDateFormat
import java.util.Locale

@SuppressLint("ConstantLocale")
val dateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.getDefault())

val activities = listOf(
    RecentActivity(0L,"Resume Optimized", "FrontEnd Developer",dateFormat.parse("2025/06/09 14:07")!!,"Resume Action"),
    RecentActivity(1L,"Referral Message Sent", "Google Product Manager", dateFormat.parse("2025/06/06 4:03")!!,"Referral Action")
)