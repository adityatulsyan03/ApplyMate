package com.example.applymate.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.applymate.R
import com.example.applymate.presentation.components.naviagtions.AppScaffold
import com.example.applymate.presentation.components.naviagtions.TopBar
import com.example.applymate.presentation.navigation.BottomNavigatorBar
import com.example.applymate.ui.theme.ApplyMateTheme

@Composable
fun ChatScreen(navController: NavHostController) {

    AppScaffold(
        topBar = {
            TopBar(
                title = "Chat"
            )
        },
        bottomBar = {
            BottomNavigatorBar(navController)
        }
    ) {

        ChatScreenContent()

    }

}

@Composable
fun ChatScreenContent() {
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

            item { ChatHeader() }
            item { DocumentUpload() }
            item { Questions() }
        }
    }
}

@Composable
fun Questions() {
    //TODO: How to show
}

@Composable
fun DocumentUpload() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        Text(
            text = "Upload Job",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onPrimary
        )
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
                text = "PDF, DOCX, or TXT",
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
                Text("Browse Files")
            }
        }
    }
}

@Composable
fun ChatHeader() {
    Text(
        text = "Document Understanding",
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.onPrimary
    )
    Text(
        text = "Upload a document and chat with AI about it",
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        color = MaterialTheme.colorScheme.onSecondary
    )
}

@Preview
@Composable
private fun Preview() {
    ApplyMateTheme{ ChatScreenContent() }
}