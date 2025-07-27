package com.example.applymate.data.model

import com.example.applymate.data.enums.ExperienceLevel
import com.example.applymate.data.enums.TimeUnit
import com.example.applymate.data.enums.WorkType

data class JobSearch(
    val searchText: String,
    val timeValue: String,
    val timeUnit: TimeUnit,
    val workType: List<WorkType>,
    val experienceLevel: List<ExperienceLevel>,
    val easyApply: Boolean,
    val verified: Boolean,
    val yourNetwork: Boolean,
    val noOfApplications: Boolean
)