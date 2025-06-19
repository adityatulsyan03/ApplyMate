package com.example.applymate.utils

import android.graphics.BlurMaskFilter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
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

fun Modifier.customShadow(
    color: Color = Color.Black,
    borderRadius: Dp = 0.dp,
    blurRadius: Dp = 0.dp,
    offsetY: Dp = 0.dp,
    offsetX: Dp = 0.dp,
    spread: Dp = 0f.dp,
    modifier: Modifier = Modifier
) = this.then(
    modifier.drawBehind {
        this.drawIntoCanvas {
            val paint = Paint()
            val frameworkPaint = paint.asFrameworkPaint()
            val spreadPixel = spread.toPx()
            val leftPixel = (0f - spreadPixel) + offsetX.toPx()
            val topPixel = (0f - spreadPixel) + offsetY.toPx()
            val rightPixel = (this.size.width + spreadPixel)
            val bottomPixel = (this.size.height + spreadPixel)

            if (blurRadius != 0.dp) {
                frameworkPaint.maskFilter =
                    (BlurMaskFilter(blurRadius.toPx(), BlurMaskFilter.Blur.NORMAL))
            }

            frameworkPaint.color = color.toArgb()
            it.drawRoundRect(
                left = leftPixel,
                top = topPixel,
                right = rightPixel,
                bottom = bottomPixel,
                radiusX = borderRadius.toPx(),
                radiusY = borderRadius.toPx(),
                paint
            )
        }
    }
)

//fun Modifier.customShadow(
//    color: Color = Color.Black,
//    borderRadius: Dp = 0.dp,
//    blurRadius: Dp = 0.dp,
//    offsetY: Dp = 0.dp,
//    offsetX: Dp = 0.dp,
//    spread: Dp = 0.dp,
//    modifier: Modifier = Modifier
//) = this.then(
//    modifier.drawBehind {
//        drawIntoCanvas {
//            val paint = Paint()
//            val frameworkPaint = paint.asFrameworkPaint()
//
//            val spreadPx = spread.toPx()
//            val offsetXPx = offsetX.toPx()
//            val offsetYPx = offsetY.toPx()
//
//            // 👇 Custom bounds: no shadow on top
//            val left = 0f - spreadPx + offsetXPx
//            val top = 0f - spreadPx + offsetYPx
//            val right = size.width + spreadPx + offsetXPx
//            val bottom = size.height + spreadPx + offsetYPx
//
//            if (blurRadius != 0.dp) {
//                frameworkPaint.maskFilter =
//                    BlurMaskFilter(blurRadius.toPx(), BlurMaskFilter.Blur.NORMAL)
//            }
//
//            frameworkPaint.color = color.toArgb()
//
//            it.drawRoundRect(
//                left = left,
//                top = top,
//                right = right,
//                bottom = bottom,
//                radiusX = borderRadius.toPx(),
//                radiusY = borderRadius.toPx(),
//                paint = paint
//            )
//        }
//    }
//)