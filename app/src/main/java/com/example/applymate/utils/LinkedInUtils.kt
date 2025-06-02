package com.example.applymate.utils

import android.content.Context
import android.content.Intent
import android.net.Uri

fun openLinkedInProfile(context: Context, username: String) {
    val linkedInUrl = "https://www.linkedin.com/in/$username"
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(linkedInUrl))
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)

    try {
        context.startActivity(intent)
    } catch (e: Exception) {
        // If LinkedIn app is not installed, open in browser
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(linkedInUrl))
        context.startActivity(browserIntent)
    }
}