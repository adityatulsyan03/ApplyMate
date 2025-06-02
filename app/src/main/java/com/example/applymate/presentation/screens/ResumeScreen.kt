package com.example.applymate.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.applymate.R
import com.example.applymate.presentation.components.naviagtions.AppScaffold
import com.example.applymate.presentation.components.naviagtions.TopBar
import com.example.applymate.presentation.navigation.BottomNavigatorBar
import com.example.applymate.ui.theme.ApplyMateTheme

@Composable
fun ResumeScreen(navController: NavController) {

    AppScaffold(
        topBar = {
            TopBar(
                title = "Resume"
            )
        },
        bottomBar = {
            BottomNavigatorBar(navController)
        }
    ) {

        ResumeOptimizingContent()

    }

}

@Composable
fun ResumeOptimizingContent() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        LazyColumn(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            item { ResumeHeading() }
            item { UploadResumeDocument() }
            item { ResumeReview() }
            item { ResumeSuggestion() }
            item {
                Button(
                    onClick = {},
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    Text("Generate Optimized Resume")
                }
            }
        }
    }
}

@Composable
fun ResumeSuggestion() {
    val suggestions = listOf(
        listOf("Add more quantifiable achievements","Include metrics and results to demonstrate impact",false),
        listOf("Good keyword matching","Your resume contains key terms from the industry",true),
        listOf("Improve formatting for ATS","Use standard headings and avoid complex layouts",false)
    )
    val iconColorMap = mapOf(
        R.drawable.resume_action to Pair(Color(0xFF9333EA),"Resume Action"),
        R.drawable.referral_action to Pair(Color(0xFFEA580C),"Referral Action"),
        R.drawable.jobs_action to Pair(Color(0xFF2563EB),"Jobs Action"),
        R.drawable.chat_action to Pair(Color(0xFF16A34A),"Chat Action"),
        R.drawable.error_suggestion to Pair(Color(0xFFD97706),"Error Suggestion"),
        R.drawable.good_suggestion to Pair(Color(0xFF16A34A),"Good Suggestion")
    )
    Text(
        text = "AI Suggestions",
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        color = MaterialTheme.colorScheme.onPrimary
    )
    Text(
        text = "Upload a job description to get personalized suggestions",
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        color = MaterialTheme.colorScheme.onPrimary
    )
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        suggestions.forEach { suggestion ->
            SuggestionList(suggestion, iconColorMap)
        }
    }
}

@Composable
fun SuggestionList(suggestions: List<Any>, iconColorMap: Map<Int, Pair<Color, String>>) {
    val iconRes = if(suggestions[2] as Boolean) R.drawable.good_suggestion else R.drawable.error_suggestion
    val baseColor = iconColorMap[iconRes]?.first?: Color.Gray
    val iconDesc = iconColorMap[iconRes]?.second
    val backgroundColor = baseColor.copy(alpha = 0.2f)
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
                text = suggestions[0].toString(),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Text(
                text = suggestions[1].toString(),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Composable
fun ResumeReview() {
    Text(
        text = "Resume Preview",
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        color = MaterialTheme.colorScheme.onPrimary
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(150.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text("Hello My Name is Aditya, This is my resume I would like to work in your company as a Junior SDE.Hello My Name is Aditya, This is my resume I would like to work in your company as a Junior SDE.Hello My Name is Aditya, This is my resume I would like to work in your company as a Junior SDE.Hello My Name is Aditya, This is my resume I would like to work in your company as a Junior SDE.Hello My Name is Aditya, This is my resume I would like to work in your company as a Junior SDE.")
    }
}

@Composable
fun UploadResumeDocument() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp)
                .shadow(6.dp, RoundedCornerShape(16.dp))
                .clip(RoundedCornerShape(12.dp))
                .background(Color.White)
                .border(
                    width = 2.dp,
                    color = Color(0xFFF3F4F6),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
            //TODO: Apply Shadow
        ){
            Row {
                Icon(
                    painter = painterResource(R.drawable.resume_selected),
                    contentDescription = "Resume Selected",
                    modifier = Modifier.size(20.dp),
                    tint = Color.Unspecified
                )
                Text(
                    text = "Upload Resume",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
            //TODO: See how to upload Resume
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(R.drawable.job_upload),
                    contentDescription = "Job Description Upload",
                    modifier = Modifier.size(20.dp),
                    tint = Color.Unspecified
                )
                Text(
                    text = "Upload Job Description",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .dashedBorder(
                        strokeWidth = 1.dp,
                        color = Color.Gray,
                        cornerRadius = 16.dp,
                        dashLength = 10.dp,
                        gapLength = 5.dp
                    )
                    .padding(24.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.upload_icon),
                    contentDescription = "Upload",
                    modifier = Modifier.size(20.dp),
                    tint = Color.Unspecified
                )
                Text(
                    text = "Drag and drop or click to upload",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Text(
                    text = "Text or PDF format",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Button(
                    onClick = {},
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    Text("Browse Files ")
                }
            }
        }
    }
}

@Composable
fun ResumeHeading() {
    Text(
        text = "Resume Optimization",
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.onPrimary
    )
    Text(
        text = "Get AI suggestions to improve your resume",
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        color = MaterialTheme.colorScheme.onSecondary
    )
}

@Preview
@Composable
private fun Preview() {
    ApplyMateTheme{ ResumeOptimizingContent() }
}

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