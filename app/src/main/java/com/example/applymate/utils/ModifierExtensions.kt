package com.example.applymate.utils

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.dashedBorder(
    strokeWidth: Dp,
    color: Color,
    cornerRadius: Dp = 0.dp,
    dashLength: Dp = 10.dp,
    gapLength: Dp = 5.dp
): Modifier = this.then(
    Modifier.drawBehind {
        val paint = android.graphics.Paint().apply {
            isAntiAlias = true
            style = android.graphics.Paint.Style.STROKE
            this.strokeWidth = strokeWidth.toPx()
            this.color = color.toArgb()
            pathEffect = android.graphics.DashPathEffect(
                floatArrayOf(dashLength.toPx(), gapLength.toPx()),
                0f
            )
        }

        drawContext.canvas.nativeCanvas.drawRoundRect(
            0f,
            0f,
            size.width,
            size.height,
            cornerRadius.toPx(),
            cornerRadius.toPx(),
            paint
        )
    }
)