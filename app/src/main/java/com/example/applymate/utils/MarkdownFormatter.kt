package com.example.applymate.utils

import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.graphics.Color

@Composable
fun MarkdownText(text: String) {
    val annotatedString = buildAnnotatedString {
        var currentText = text
        
        // Handle bold text first
        val boldRegex = "\\*\\*(.*?)\\*\\*".toRegex()
        val parts = mutableListOf<Pair<String, Boolean>>()
        var lastIndex = 0
        
        boldRegex.findAll(currentText).forEach { match ->
            if (match.range.first > lastIndex) {
                parts.add(currentText.substring(lastIndex, match.range.first) to false)
            }
            parts.add(match.groupValues[1] to true)
            lastIndex = match.range.last + 1
        }
        
        if (lastIndex < currentText.length) {
            parts.add(currentText.substring(lastIndex) to false)
        }
        
        // Process each part
        parts.forEach { (part, isBold) ->
            val lines = part.split("\n")
            lines.forEachIndexed { index, line ->
                when {
                    line.trim().startsWith("*") && !line.trim().startsWith("**") -> {
                        append("• ")
                        val bulletText = line.removePrefix("*").trim()
                        if (isBold) {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append(bulletText)
                            }
                        } else {
                            append(bulletText)
                        }
                    }
                    else -> {
                        if (isBold && line.isNotBlank()) {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append(line)
                            }
                        } else {
                            append(line)
                        }
                    }
                }
                if (index < lines.size - 1) append("\n")
            }
        }
    }
    
    BasicText(
        text = annotatedString,
        style = MaterialTheme.typography.bodyLarge.copy(
            color = Color.Black
        )
    )
}